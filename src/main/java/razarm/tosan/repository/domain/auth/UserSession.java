package razarm.tosan.repository.domain.auth;

import java.time.Instant;

public class UserSession {

    private final String username;
    private final String sessionId;
    private final Instant createdAt;
    private final Instant expiresAt;

    public UserSession(String username, String sessionId, Instant createdAt, Instant expiresAt) {
        this.username = username;
        this.sessionId = sessionId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
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

    public Instant getExpiresAt() {
        return expiresAt;
    }


    public static final class UserSessionBuilder {
        private String username;
        private String sessionId;
        private Instant createdAt;
        private Instant expiresAt;

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

        public UserSessionBuilder expiresAt(Instant expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public UserSession build() {
            return new UserSession(username, sessionId, createdAt, expiresAt);
        }
    }
}
