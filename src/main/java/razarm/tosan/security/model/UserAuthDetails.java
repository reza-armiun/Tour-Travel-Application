package razarm.tosan.security.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAuthDetails {
    private String username;
    private boolean authenticated;
    private Set<String> authorities ;
}
