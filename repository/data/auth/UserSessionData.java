package razarm.tosan.repository.data.auth;

import java.time.Instant;

public class UserSessionData {

    private final String username;
    private final String sessionId;
    private final Instant createdAt;


    public UserSessionData(String username, String sessionId, Instant createdAt) {
        this.username = username;
        this.sessionId = sessionId;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }


    public static final class UserSessionDataBuilder {
        private String username;
        private String sessionId;
        private Instant createdAt;

        private UserSessionDataBuilder() {
        }

        public static UserSessionDataBuilder anUserSessionData() {
            return new UserSessionDataBuilder();
        }

        public UserSessionDataBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserSessionDataBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public UserSessionDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserSessionData build() {
            return new UserSessionData(username, sessionId, createdAt);
        }
    }
}
