package razarm.tosan.repository.data.auth;

public class UserAuthorityData {
    private final String userId;
    private final String authorityId;

    public UserAuthorityData(String userId, String authorityId) {
        this.userId = userId;
        this.authorityId = authorityId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthorityId() {
        return authorityId;
    }


    public static final class UserAuthorityDataBuilder {
        private String userId;
        private String authorityId;

        private UserAuthorityDataBuilder() {
        }

        public static UserAuthorityDataBuilder anUserAuthorityData() {
            return new UserAuthorityDataBuilder();
        }

        public UserAuthorityDataBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserAuthorityDataBuilder authorityId(String authorityId) {
            this.authorityId = authorityId;
            return this;
        }

        public UserAuthorityData build() {
            return new UserAuthorityData(userId, authorityId);
        }
    }
}
