package razarm.tosan.controller.dto.auth;

public class LogoutWithCredential {
    private final String username;
    private final String password;

    public LogoutWithCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public static final class LogoutWithCredentialBuilder {
        private String username;
        private String password;

        private LogoutWithCredentialBuilder() {
        }

        public static LogoutWithCredentialBuilder aLogoutWithCredential() {
            return new LogoutWithCredentialBuilder();
        }

        public LogoutWithCredentialBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LogoutWithCredentialBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LogoutWithCredential build() {
            return new LogoutWithCredential(username, password);
        }
    }
}
