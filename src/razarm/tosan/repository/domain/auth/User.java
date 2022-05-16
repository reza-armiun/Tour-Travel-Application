package razarm.tosan.repository.domain.auth;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Booking;

import java.time.Instant;

public abstract class User extends BaseEntity implements UserDetails  {

    protected final String name;
    protected final String username;
    protected final String password;

    protected final String email;
    protected final String phone;
    protected final Long nationalId;
    protected final Boolean validEmail;
    protected final Boolean isExpired;
    protected final Boolean isEnabled;
    protected final Boolean isCredentialsNonExpired;

    public User(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired) {
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

    public Boolean getValidEmail() {
        return validEmail;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public Boolean getCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", nationalId=").append(nationalId);
        sb.append(", validEmail=").append(validEmail);
        sb.append(", isExpired=").append(isExpired);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", isCredentialsNonExpired=").append(isCredentialsNonExpired);
        sb.append('}');
        return sb.toString();
    }
}
