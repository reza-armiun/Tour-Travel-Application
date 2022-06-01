package razarm.tosan.repository.domain.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import razarm.tosan.repository.domain.Booking;
import razarm.tosan.repository.domain.Interest;
import razarm.tosan.repository.domain.location.Address;

import java.time.Instant;
import java.util.Collection;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class PremiumUser extends User {
    private final PremiumType type ;

    private final Set<Authority> authorities ;
    private final Set<Booking> bookings ;
    private final Set<Interest> interests;

    public PremiumUser(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, String imageUrl, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired, Address address, PremiumType type, Set<Authority> authorities, Set<Booking> bookings, Set<Interest> interests) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, validEmail, isExpired, isEnabled, isCredentialsNonExpired, address);
        this.type = type;
        this.authorities = authorities;
        this.bookings = bookings;
        this.interests = interests;
    }

    public PremiumType getType() {
        return type;
    }


    public Set<Booking> getBookings() {
        return bookings;
    }

    public Set<Interest> getInterests() {
        return interests;
    }




    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", PremiumUser.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("type=" + type)
                .add("authorities=" + authorities)
                .add("bookings=" + bookings)
                .add("interests=" + interests)
                .add("name='" + name + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .add("nationalId=" + nationalId)
                .add("validEmail=" + validEmail)
                .add("isExpired=" + isExpired)
                .add("isEnabled=" + isEnabled)
                .add("isCredentialsNonExpired=" + isCredentialsNonExpired)
                .toString();
    }

    @Override
    public PremiumUser cloneWithId(String id) {
        return new PremiumUser(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, validEmail, isExpired, isEnabled, isCredentialsNonExpired, address, type, authorities, bookings, interests);
    }

    public PremiumUser cloneWithBookings(Set<Booking> bookings) {
        return new PremiumUser(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, validEmail, isExpired, isEnabled, isCredentialsNonExpired, address, type, authorities, bookings, interests);
    }

    public PremiumUser cloneWithNewPassword(String password) {
        return new PremiumUser(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, validEmail, isExpired, isEnabled, isCredentialsNonExpired, address, type, authorities, bookings, interests);
    }


    public static final class PremiumUserBuilder {
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
        protected String imageUrl;
        protected Boolean validEmail;
        protected Boolean isExpired;
        protected Boolean isEnabled;
        protected Boolean isCredentialsNonExpired;
        protected Address address;
        private PremiumType type ;
        private Set<Authority> authorities ;
        private Set<Booking> bookings ;
        private Set<Interest> interests;

        private PremiumUserBuilder() {
        }

        public static PremiumUserBuilder aPremiumUser() {
            return new PremiumUserBuilder();
        }

        public PremiumUserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PremiumUserBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PremiumUserBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PremiumUserBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PremiumUserBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PremiumUserBuilder type(PremiumType type) {
            this.type = type;
            return this;
        }

        public PremiumUserBuilder authorities(Set<Authority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public PremiumUserBuilder bookings(Set<Booking> bookings) {
            this.bookings = bookings;
            return this;
        }

        public PremiumUserBuilder interests(Set<Interest> interests) {
            this.interests = interests;
            return this;
        }

        public PremiumUserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PremiumUserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PremiumUserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public PremiumUserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PremiumUserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PremiumUserBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public PremiumUserBuilder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public PremiumUserBuilder validEmail(Boolean validEmail) {
            this.validEmail = validEmail;
            return this;
        }

        public PremiumUserBuilder isExpired(Boolean isExpired) {
            this.isExpired = isExpired;
            return this;
        }

        public PremiumUserBuilder isEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public PremiumUserBuilder isCredentialsNonExpired(Boolean isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public PremiumUserBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public PremiumUser build() {
            return new PremiumUser(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, validEmail, isExpired, isEnabled, isCredentialsNonExpired, address, type, authorities, bookings, interests);
        }
    }
}
