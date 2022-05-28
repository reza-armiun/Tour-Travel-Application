package razarm.tosan.security.jwt;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("app.security")
//@Profile("security")
public class JwtProperties {
    private  String secret;
    private  String tokenPrefix;
    private Integer tokenExpirationAfterDays;
}