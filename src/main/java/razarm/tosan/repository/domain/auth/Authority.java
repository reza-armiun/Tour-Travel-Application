package razarm.tosan.repository.domain.auth;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class Authority extends BaseEntity {
    private final String name;
    private final Set<User> users;

    public Authority(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Set<User> users) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.users = AppCollections.unmodifiableSet(users);
    }

    public String getName() {
        return name;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new Authority(id, createdAt, modifiedAt, createdBy, modifiedBy, name, users);
    }


    public static final class AuthorityBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private Set<User> users;

        private AuthorityBuilder() {
        }

        public static AuthorityBuilder anAuthority() {
            return new AuthorityBuilder();
        }

        public AuthorityBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AuthorityBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AuthorityBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AuthorityBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AuthorityBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AuthorityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AuthorityBuilder users(Set<User> users) {
            this.users = users;
            return this;
        }

        public Authority build() {
            return new Authority(id, createdAt, modifiedAt, createdBy, modifiedBy, name, users);
        }
    }
}
