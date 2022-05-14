package razarm.tosan.controller.dto.auth;

public class SignupRequest {
    private final String name;
    private final String email;
    private final String username;
    private final String password;
    private final String rePassword;

    public SignupRequest(String name, String email, String username, String password, String rePassword) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rePassword = rePassword;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRePassword() {
        return rePassword;
    }


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
