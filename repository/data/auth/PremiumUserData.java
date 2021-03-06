package razarm.tosan.repository.data.auth;

import razarm.tosan.repository.domain.Booking;
import razarm.tosan.repository.domain.auth.PremiumType;

import java.time.Instant;
import java.util.Set;

public class PremiumUserData extends UserData{
    private final PremiumType type ;
    private final Set<String> authorityIds ;
    private final Set<String> bookingIds ;
    private final Set<InterestData> interests;


    public PremiumUserData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, Booking validEmail, Booking isExpired, Booking isEnabled, Booking isCredentialsNonExpired, PremiumType type, Set<String> authorityIds, Set<String> bookingIds, Set<InterestData> interests) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired);
        this.type = type;
        this.authorityIds = authorityIds;
        this.bookingIds = bookingIds;
        this.interests = interests;
    }

    public PremiumType getType() {
        return type;
    }

    public Set<String> getAuthorityIds() {
        return authorityIds;
    }

    public Set<String> getBookingIds() {
        return bookingIds;
    }

    public Set<InterestData> getInterests() {
        return interests;
    }

    @Override
    public PremiumUserData cloneWithId(String id) {
        return new PremiumUserData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, type, authorityIds, bookingIds, interests);
    }


    public static final class PremiumUserDataBuilder {
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
        private Set<String> authorityIds ;
        private Set<String> bookingIds ;
        private Set<InterestData> interests;

        private PremiumUserDataBuilder() {
        }

        public static PremiumUserDataBuilder aPremiumUserData() {
            return new PremiumUserDataBuilder();
        }

        public PremiumUserDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PremiumUserDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PremiumUserDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PremiumUserDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PremiumUserDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PremiumUserDataBuilder type(PremiumType type) {
            this.type = type;
            return this;
        }

        public PremiumUserDataBuilder authorityIds(Set<String> authorityIds) {
            this.authorityIds = authorityIds;
            return this;
        }

        public PremiumUserDataBuilder bookingIds(Set<String> bookingIds) {
            this.bookingIds = bookingIds;
            return this;
        }

        public PremiumUserDataBuilder interests(Set<InterestData> interests) {
            this.interests = interests;
            return this;
        }

        public PremiumUserDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PremiumUserDataBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PremiumUserDataBuilder password(String password) {
            this.password = password;
            return this;
        }

        public PremiumUserDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PremiumUserDataBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PremiumUserDataBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public PremiumUserDataBuilder validEmail(Booking validEmail) {
            this.validEmail = validEmail;
            return this;
        }

        public PremiumUserDataBuilder isExpired(Booking isExpired) {
            this.isExpired = isExpired;
            return this;
        }

        public PremiumUserDataBuilder isEnabled(Booking isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public PremiumUserDataBuilder isCredentialsNonExpired(Booking isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public PremiumUserData build() {
            return new PremiumUserData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, type, authorityIds, bookingIds, interests);
        }
    }
}
