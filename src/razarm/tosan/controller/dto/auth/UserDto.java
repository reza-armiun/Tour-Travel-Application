package razarm.tosan.controller.dto.auth;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.Booking;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

public class UserDto extends BaseEntityDto {
    protected final String name;
    protected final String username;
    protected final String phone;
    protected final String email;
    protected final Long nationalId;
    protected final Booking validEmail;
    protected final Booking isExpired;
    protected final Booking isEnabled;
    protected final Booking isCredentialsNonExpired;

    public UserDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String username, String phone, String email, Long nationalId, Booking validEmail, Booking isExpired, Booking isEnabled, Booking isCredentialsNonExpired) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.nationalId = nationalId;
        this.validEmail = validEmail;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }


    public Booking getValidEmail() {
        return validEmail;
    }

    public Booking getIsExpired() {
        return isExpired;
    }

    public Booking getIsEnabled() {
        return isEnabled;
    }

    public Booking getIsCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("username='" + username + "'")
                .add("phone='" + phone + "'")
                .add("email='" + email + "'")
                .add("nationalId=" + nationalId)
                .add("validEmail=" + validEmail)
                .add("isExpired=" + isExpired)
                .add("isEnabled=" + isEnabled)
                .add("isCredentialsNonExpired=" + isCredentialsNonExpired)
                .toString();
    }
}
