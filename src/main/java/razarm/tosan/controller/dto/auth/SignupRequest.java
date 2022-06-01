package razarm.tosan.controller.dto.auth;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupRequest {
    private  String name;
    private  String email;
    private  String username;
    private  String password;
    private  String rePassword;



    @Override
    public String toString() {
        return "SignupRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rePassword='" + rePassword + '\'' +
                '}';
    }

    public static final class SignupRequestBuilder {
        private String name;
        private String email;
        private String username;
        private String password;
        private String rePassword;

        private SignupRequestBuilder() {
        }

        public static SignupRequestBuilder aSignupRequest() {
            return new SignupRequestBuilder();
        }

        public SignupRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SignupRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public SignupRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public SignupRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public SignupRequestBuilder rePassword(String rePassword) {
            this.rePassword = rePassword;
            return this;
        }

        public SignupRequest build() {
            return new SignupRequest(name, email, username, password, rePassword);
        }
    }
}
