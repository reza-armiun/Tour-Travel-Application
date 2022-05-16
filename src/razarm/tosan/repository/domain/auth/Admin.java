package razarm.tosan.repository.domain.auth;

import razarm.tosan.repository.domain.Booking;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class Admin extends User{

    private final Set<Authority> authorities ;

    public Admin(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired, Set<Authority> authorities) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired);
        this.authorities = authorities;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    @Override
    public Admin cloneWithId(String id) {
        return new Admin(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, authorities);
    }


    public static final class AdminBuilder {
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
        private Set<Authority> authorities ;

        private AdminBuilder() {
        }

        public static AdminBuilder anAdmin() {
            return new AdminBuilder();
        }

        public AdminBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AdminBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AdminBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AdminBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AdminBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AdminBuilder authorities(Set<Authority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public AdminBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AdminBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AdminBuilder password(String password) {
            this.password = password;
            return this;
        }

        public AdminBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AdminBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public AdminBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public AdminBuilder validEmail(Boolean validEmail) {
            this.validEmail = validEmail;
            return this;
        }

        public AdminBuilder isExpired(Boolean isExpired) {
            this.isExpired = isExpired;
            return this;
        }

        public AdminBuilder isEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public AdminBuilder isCredentialsNonExpired(Boolean isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public Admin build() {
            return new Admin(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, authorities);
        }
    }
}
