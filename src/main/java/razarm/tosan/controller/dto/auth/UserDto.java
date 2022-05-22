package razarm.tosan.controller.dto.auth;

import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

public class UserDto extends BaseEntityDto {
    protected  String name;
    protected  String username;
    protected  String phone;
    protected  String email;
    protected  Long nationalId;
    protected  Boolean validEmail;
    protected  Boolean isExpired;
    protected  Boolean isEnabled;
    protected  Boolean isCredentialsNonExpired;


    public UserDto() {}

    public UserDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String username, String phone, String email, Long nationalId, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
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
