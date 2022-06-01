package razarm.tosan.security.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatePasswordRequest {
    private String username;
    private String oldPassword;
    private String password;
    private String rePassword;
}
