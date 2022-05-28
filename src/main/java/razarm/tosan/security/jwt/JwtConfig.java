package razarm.tosan.security.jwt;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class JwtConfig {
    private final JwtProperties jwtProperties;




    public String getSecretKey() {
        return jwtProperties.getSecret();
    }


    public String getTokenPrefix() {
        return jwtProperties.getTokenPrefix();
    }


    public Integer getTokenExpirationAfterDays() {
        return jwtProperties.getTokenExpirationAfterDays();
    }



    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}