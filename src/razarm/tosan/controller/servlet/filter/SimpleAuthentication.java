package razarm.tosan.controller.servlet.filter;

public class SimpleAuthentication implements Authentication {
    private String username;
    private String password;

    public SimpleAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final class SimpleAuthenticationBuilder {
        private String username;
        private String password;

        private SimpleAuthenticationBuilder() {
        }

        public static SimpleAuthenticationBuilder aSimpleAuthentication() {
            return new SimpleAuthenticationBuilder();
        }

        public SimpleAuthenticationBuilder username(String username) {
            this.username = username;
            return this;
        }

        public SimpleAuthenticationBuilder password(String password) {
            this.password = password;
            return this;
        }

        public SimpleAuthentication build() {
            return new SimpleAuthentication(username, password);
        }
    }
}
