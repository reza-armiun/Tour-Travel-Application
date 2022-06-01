package razarm.tosan.repository.data.auth;

import razarm.tosan.repository.data.location.AddressData;
import razarm.tosan.repository.domain.auth.PremiumType;

import java.time.Instant;
import java.util.Set;

public class PremiumUserData extends UserData{
    private final PremiumType type ;
    private final Set<String> authorities;
    private final Set<String> bookingIds ;
    private final Set<InterestData> interests;


    public PremiumUserData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, String imageUrl, AddressData addressData, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired, PremiumType type, Set<String> authorities, Set<String> bookingIds, Set<InterestData> interests) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, addressData, validEmail, isExpired, isEnabled, isCredentialsNonExpired);
        this.type = type;
        this.authorities = authorities;
        this.bookingIds = bookingIds;
        this.interests = interests;
    }

    public PremiumType getType() {
        return type;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public Set<String> getBookingIds() {
        return bookingIds;
    }

    public Set<InterestData> getInterests() {
        return interests;
    }

    @Override
    public PremiumUserData cloneWithId(String id) {
        return new PremiumUserData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, addressData, validEmail, isExpired, isEnabled, isCredentialsNonExpired, type, authorities, bookingIds, interests);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PremiumUserData{");
        sb.append("id='").append(id).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append(", type=").append(type);
        sb.append(", authorities=").append(authorities);
        sb.append(", bookingIds=").append(bookingIds);
        sb.append(", interests=").append(interests);
        sb.append(", name='").append(name).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", nationalId=").append(nationalId);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", addressData=").append(addressData);
        sb.append(", validEmail=").append(validEmail);
        sb.append(", isExpired=").append(isExpired);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", isCredentialsNonExpired=").append(isCredentialsNonExpired);
        sb.append('}');
        return sb.toString();
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
        protected String imageUrl;
        protected AddressData addressData;
        protected Boolean validEmail;
        protected Boolean isExpired;
        protected Boolean isEnabled;
        protected Boolean isCredentialsNonExpired;
        private PremiumType type ;
        private Set<String> authorities;
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

        public PremiumUserDataBuilder authorities(Set<String> authorities) {
            this.authorities = authorities;
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

        public PremiumUserDataBuilder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public PremiumUserDataBuilder addressData(AddressData addressData) {
            this.addressData = addressData;
            return this;
        }

        public PremiumUserDataBuilder validEmail(Boolean validEmail) {
            this.validEmail = validEmail;
            return this;
        }

        public PremiumUserDataBuilder isExpired(Boolean isExpired) {
            this.isExpired = isExpired;
            return this;
        }

        public PremiumUserDataBuilder isEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public PremiumUserDataBuilder isCredentialsNonExpired(Boolean isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public PremiumUserData build() {
            return new PremiumUserData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, password, email, phone, nationalId, imageUrl, addressData, validEmail, isExpired, isEnabled, isCredentialsNonExpired, type, authorities, bookingIds, interests);
        }
    }
}
