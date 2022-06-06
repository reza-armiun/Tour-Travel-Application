package razarm.tosan.repository.data.auth;

import lombok.ToString;
import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.data.location.AddressData;
import razarm.tosan.repository.data.tour.BookingData;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;


@ToString
public abstract class UserData extends BaseEntityData {
    protected final String name;
    protected final String username;
    protected final String password;
    protected final String email;
    protected final String phone;
    protected final Long nationalId;
    protected final String imageUrl;
    protected final AddressData addressData;
    protected final Boolean validEmail;
    protected final Boolean isExpired;
    protected final Boolean isEnabled;
    protected final Boolean isCredentialsNonExpired;

    protected final Set<BookingData> bookings;

    public UserData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String username, String password, String email, String phone, Long nationalId, String imageUrl, AddressData addressData, Boolean validEmail, Boolean isExpired, Boolean isEnabled, Boolean isCredentialsNonExpired, Set<BookingData> bookings) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.nationalId = nationalId;
        this.imageUrl = imageUrl;
        this.addressData = addressData;
        this.validEmail = validEmail;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.bookings = bookings;
    }

    public String getImageUrl() {
        return imageUrl;
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

    public AddressData getAddressData() {
        return addressData;
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

    public Set<BookingData> getBookings() {
        return bookings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserData userData = (UserData) o;
        return Objects.equals(name, userData.name) && Objects.equals(username, userData.username) && Objects.equals(password, userData.password) && Objects.equals(email, userData.email) && Objects.equals(phone, userData.phone) && Objects.equals(nationalId, userData.nationalId) && Objects.equals(validEmail, userData.validEmail) && Objects.equals(isExpired, userData.isExpired) && Objects.equals(isEnabled, userData.isEnabled) && Objects.equals(isCredentialsNonExpired, userData.isCredentialsNonExpired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, username, password, email, phone, nationalId, validEmail, isExpired, isEnabled, isCredentialsNonExpired);
    }
}
