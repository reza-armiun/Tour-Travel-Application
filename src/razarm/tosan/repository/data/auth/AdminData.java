package razarm.tosan.repository.data.auth;


import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.Booking;

import java.time.Instant;
import java.util.Set;

public class AdminData extends UserData {
    private final Set<String> authorityIds ;

    public AdminData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired, Set<String> authorityIds) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired);
        this.authorityIds = authorityIds;
    }

    public Set<String> getAuthorityIds() {
        return authorityIds;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new AdminData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, authorityIds);
    }


    public static final class AdminDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected String username;
        protected String password;
        protected String email;
        protected String phone;
        protected Long nationalId;
        protected Boolean validEmail;
        protected Boolean isExpired;
        protected Boolean isEnabled;
        protected Boolean isCredentialsNonExpired;
        private Set<String> authorityIds ;

        private AdminDataBuilder() {
        }

        public static AdminDataBuilder anAdminData() {
            return new AdminDataBuilder();
        }

        public AdminDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AdminDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AdminDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AdminDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AdminDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AdminDataBuilder authorityIds(Set<String> authorityIds) {
            this.authorityIds = authorityIds;
            return this;
        }

        public AdminDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AdminDataBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AdminDataBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AdminDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AdminDataBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public AdminDataBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public AdminDataBuilder validEmail(Boolean validEmail) {
            this.validEmail = validEmail;
            return this;
        }

        public AdminDataBuilder isExpired(Boolean isExpired) {
            this.isExpired = isExpired;
            return this;
        }

        public AdminDataBuilder isEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public AdminDataBuilder isCredentialsNonExpired(Boolean isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public AdminData build() {
            return new AdminData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, authorityIds);
        }
    }
}
