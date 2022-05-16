package razarm.tosan.controller.dto.auth;

public class LoginRequest {
    private  String username;
    private  String password;
    private  Boolean rememberMe;


    public LoginRequest() {

    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoginRequest{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", rememberMe=").append(rememberMe);
        sb.append('}');
        return sb.toString();
    }
}
