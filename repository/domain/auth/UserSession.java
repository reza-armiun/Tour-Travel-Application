package razarm.tosan.repository.domain.auth;

import java.time.Instant;

public class UserSession {

    private final String username;
    private final String sessionId;
    private final Instant createdAt;

    public UserSession(String username, String sessionId, Instant createdAt) {
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


    public static final class UserSessionBuilder {
        private String username;
        private String sessionId;
        private Instant createdAt;

        private UserSessionBuilder() {
        }

        public static UserSessionBuilder anUserSession() {
            return new UserSessionBuilder();
        }

        public UserSessionBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserSessionBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public UserSessionBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserSession build() {
            return new UserSession(username, sessionId, createdAt);
        }
    }
}
