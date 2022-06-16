package razarm.tosan.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import razarm.tosan.controller.rest.resolver.ErrorDetails;
import razarm.tosan.security.model.Session;
import razarm.tosan.security.model.UserAuthDetails;
import razarm.tosan.security.services.SessionService;
import razarm.tosan.utility.AppJsonMapper;


import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final SessionService userSessionService;
    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;



    public JwtUsernameAndPasswordAuthenticationFilter(SessionService userSessionService, AuthenticationManager authenticationManager, JwtConfig jwtConfig, SecretKey secretKey) {
        setFilterProcessesUrl("/v1/login");
        setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
        this.userSessionService = userSessionService;
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );


            return authenticationManager.authenticate(authentication);

        }
        catch (InternalAuthenticationServiceException e) {
            throw new AuthenticationCredentialsNotFoundException(e.getMessage());

        }
        catch (IOException | AuthenticationException e) {
            if(e instanceof AuthenticationException) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ((AuthenticationException) e).getMessage());
//                return null;
                throw new AuthenticationCredentialsNotFoundException("Invalid username or password, please try again");
            } else throw new UsernameNotFoundException("User name not found...."); //TODO
        }

    }



    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws JsonProcessingException {

        final String username = authResult.getName();
        final Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        final UserDetails user = (UserDetails) authResult.getDetails();
        log.info("successful authentication : {}", user.getUsername());
        final java.sql.Date expiration = java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays()).toString());

        final String token = Jwts.builder()
                .setSubject(username)
                .claim("authorities", authorities)
                .setIssuedAt(new Date())
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();

        this.userSessionService.insertSession(
                new Session(username , token));

        final Cookie jwtTokenCookie = new Cookie(jwtConfig.getAuthorizationHeader() ,  token );
        jwtTokenCookie.setHttpOnly(true);
        final int maxAge = jwtConfig.getTokenExpirationAfterDays() * 86400;  //24 * 60 * 60
        jwtTokenCookie.setMaxAge(maxAge);
        jwtTokenCookie.setPath("/");
        response.addCookie(jwtTokenCookie);
        UserAuthDetails userAuthDetails = UserAuthDetails.builder()
                                               .username(username)
                                               .authorities(
                                                       authorities.stream()
                                                                  .map(GrantedAuthority::getAuthority)
                                                                  .collect(Collectors.toSet()))
                                                         .authenticated(true)
                                               .build();
        response.addHeader(
                "user-info",
                AppJsonMapper.getAppJsonMapper().writeValueAsString(userAuthDetails));

    }


}


class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        ErrorDetails error = new ErrorDetails(HttpStatus.UNAUTHORIZED, e.getMessage(), "Invalid Credentials");

        try {
            String json = objectMapper.writeValueAsString(error);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            response.getWriter().write(json);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}