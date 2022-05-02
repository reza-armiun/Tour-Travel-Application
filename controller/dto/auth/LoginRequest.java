package razarm.tosan.controller.dto.auth;

public class LoginRequest {
    private final String username;
    private final String password;
    private final Boolean rememberMe;

    public LoginRequest(String username, String password, Boolean rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }


    public static final class LoginRequestBuilder {
        private String username;
        private String password;
        private Boolean rememberMe;

        private LoginRequestBuilder() {
        }

        public static LoginRequestBuilder aLoginRequest() {
            return new LoginRequestBuilder();
        }

        public LoginRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LoginRequestBuilder rememberMe(Boolean rememberMe) {
            this.rememberMe = rememberMe;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(username, password, rememberMe);
        }
    }
}
