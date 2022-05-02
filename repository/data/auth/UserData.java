package razarm.tosan.repository.data.auth;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.Booking;

import java.time.Instant;

public abstract class UserData extends BaseEntityData {
    protected final String name;
    protected final String username;
    protected final String password;
    protected final String email;
    protected final String phone;
    protected final Long nationalId;
    protected final Booking validEmail;
    protected final Booking isExpired;
    protected final Booking isEnabled;
    protected final Booking isCredentialsNonExpired;

    public UserData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, Booking validEmail, Booking isExpired, Booking isEnabled, Booking isCredentialsNonExpired) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.nationalId = nationalId;
        this.validEmail = validEmail;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Long getNationalId() {
        return nationalId;
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
}
