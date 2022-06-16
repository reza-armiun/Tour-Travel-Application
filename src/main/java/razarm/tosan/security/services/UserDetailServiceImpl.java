package razarm.tosan.security.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.security.bruteforce.LoginAttemptService;
import razarm.tosan.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.stream.Collectors;


@Slf4j
@Service("appUserDetailService")
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final AuthService authService;
    private final LoginAttemptService loginAttemptService;
    private final HttpServletRequest request;

    private String getClientIp() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if(xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final String ip = getClientIp();
        if(loginAttemptService.isBlocked(ip)) {
            throw new InternalAuthenticationServiceException("Your ip is temporarily blocked, Please try later");
        }

        try{
            final User user = this.authService.findUserByUsername(username);
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return user.getAuthorities().stream()
                            .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                            .collect(Collectors.toUnmodifiableSet());
                }

                @Override
                public String getPassword() {
                    return user.getPassword();
                }

                @Override
                public String getUsername() {
                    return user.getUsername();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        }catch (RuntimeException e ) {
            if (e instanceof AuthenticationException) throw e;
            throw new InternalAuthenticationServiceException("Error while executing loadUserByUsername", e);
        }
    }




}
