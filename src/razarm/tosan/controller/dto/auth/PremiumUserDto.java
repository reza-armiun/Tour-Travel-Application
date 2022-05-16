package razarm.tosan.controller.dto.auth;

import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.repository.domain.Booking;

import java.time.ZonedDateTime;
import java.util.Set;

public class PremiumUserDto extends UserDto {
    private  Set<String> authorities;
    private  Set<BookingDto> bookings;
    private  Set<InterestDto> interests;

    public PremiumUserDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String username, String phone, String email, Long nationalId, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired, Set<String> authorities, Set<BookingDto> bookings, Set<InterestDto> interests) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, phone, email, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired);
        this.authorities = authorities;
        this.bookings = bookings;
        this.interests = interests;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public Set<BookingDto> getBookings() {
        return bookings;
    }

    public Set<InterestDto> getInterests() {
        return interests;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public void setBookings(Set<BookingDto> bookings) {
        this.bookings = bookings;
    }

    public void setInterests(Set<InterestDto> interests) {
        this.interests = interests;
    }

    public static final class PremiumUserDtoBuilder {
        protected  String id;
        protected ZonedDateTime createdAt;
        protected  ZonedDateTime modifiedAt;
        protected  String createdBy;
        protected  String modifiedBy;
        protected  String name;
        protected  String username;
        protected  String phone;
        protected  String email;
        protected  Long nationalId;
        protected  Boolean validEmail;
        protected  Boolean isExpired;
        protected  Boolean isEnabled;
        protected  Boolean isCredentialsNonExpired;
        private Set<String> authorities;
        private  Set<BookingDto> bookings;
        private  Set<InterestDto> interests;

        private PremiumUserDtoBuilder() {
        }

        public static PremiumUserDtoBuilder aPremiumUserDto() {
            return new PremiumUserDtoBuilder();
        }

        public PremiumUserDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PremiumUserDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PremiumUserDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PremiumUserDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PremiumUserDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PremiumUserDtoBuilder authorities(Set<String> authorities) {
            this.authorities = authorities;
            return this;
        }

        public PremiumUserDtoBuilder bookings(Set<BookingDto> bookings) {
            this.bookings = bookings;
            return this;
        }

        public PremiumUserDtoBuilder interests(Set<InterestDto> interests) {
            this.interests = interests;
            return this;
        }

        public PremiumUserDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PremiumUserDtoBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PremiumUserDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PremiumUserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PremiumUserDtoBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public PremiumUserDtoBuilder validEmail(Boolean validEmail) {
            this.validEmail = validEmail;
            return this;
        }

        public PremiumUserDtoBuilder isExpired(Boolean isExpired) {
            this.isExpired = isExpired;
            return this;
        }

        public PremiumUserDtoBuilder isEnabled(Boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public PremiumUserDtoBuilder isCredentialsNonExpired(Boolean isCredentialsNonExpired) {
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }

        public PremiumUserDto build() {
            return new PremiumUserDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, phone, email, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired, authorities, bookings, interests);
        }
    }
}
