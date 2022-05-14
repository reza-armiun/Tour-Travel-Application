package razarm.tosan.repository.domain.auth;

import razarm.tosan.repository.domain.Booking;
import razarm.tosan.repository.domain.Interest;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class PremiumUser extends User {
    private final PremiumType type ;

    private final Set<Authority> authorities ;
    private final Set<Booking> bookings ;
    private final Set<Interest> interests;

    public PremiumUser(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, Booking validEmail, Booking isExpired, Booking isEnabled, Booking isCredentialsNonExpired, PremiumType type, Set<Authority> authorities, Set<Booking> bookings, Set<Interest> interests) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired);
        this.type = type;
        this.authorities = AppCollections.unmodifiableSet(authorities);
        this.bookings = AppCollections.unmodifiableSet(bookings);
        this.interests = AppCollections.unmodifiableSet(interests);
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
    public String toString() {
        return "PremiumUser{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", type=" + type +
                ", authorities=" + authorities +
                ", bookings=" + bookings +
                ", interests=" + interests +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", nationalId=" + nationalId +
                '}';
    }

    @Override
    public PremiumUser cloneWithId(String id) {
        return new PremiumUser(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, type, authorities, bookings, interests);
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
        protected Booking validEmail;
        protected Booking isExpired;
        protected Booking isEnabled;
        protected Booking isCredentialsNonExpired;
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

        public PremiumUserBuilder validEmail(Booking validEmail) {
            this.validEmail = validEmail;
            return this;
        }

        public PremiumUserBuilder isExpired(Booking isExpired) {
            this.isExpired = isExpired;
            return this;
        }

        public PremiumUserBuilder isEnabled(Booking isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public PremiumUserBuilder isCredentialsNonExpired(Booking isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public PremiumUser build() {
            return new PremiumUser(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, type, authorities, bookings, interests);
        }
    }
}
