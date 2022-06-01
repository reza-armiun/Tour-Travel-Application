package razarm.tosan.controller.dto.auth;

import lombok.Getter;
import lombok.Setter;
import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

@Getter
@Setter
public class UserDto extends BaseEntityDto {
    protected  String name;
    protected  String username;
    protected  String phone;
    protected  String email;
    protected  Long nationalId;
    protected  String imageUrl;
    protected  AddressDto address;
    protected  Boolean validEmail;
    protected  Boolean isExpired;
    protected  Boolean isEnabled;
    protected  Boolean isCredentialsNonExpired;


    public UserDto() {}

    public UserDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String username, String phone, String email, Long nationalId, String imageUrl, AddressDto address, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.nationalId = nationalId;
        this.imageUrl = imageUrl;
        this.address = address;
        this.validEmail = validEmail;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Boolean getValidEmail() {
        return validEmail;
    }

    public void setValidEmail(Boolean validEmail) {
        this.validEmail = validEmail;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
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
