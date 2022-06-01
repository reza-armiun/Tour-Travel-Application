package razarm.tosan.repository.domain.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.location.Address;

import java.time.Instant;
@Getter
@Setter
public abstract class User extends BaseEntity implements UserDetails {

    protected  String name;
    protected  String username;
    protected  String password;

    protected  String email;
    protected  String phone;
    protected  Long nationalId;
    protected  String imageUrl;
    protected  Boolean validEmail;
    protected  Boolean isExpired;
    protected  Boolean isEnabled;
    protected  Boolean isCredentialsNonExpired;
    protected  Address address;

    public User(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, String imageUrl, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired, Address address) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.nationalId = nationalId;
        this.imageUrl = imageUrl;
        this.validEmail = validEmail;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.address = address;
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
