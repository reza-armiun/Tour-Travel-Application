package razarm.tosan.controller.dto.accommodation;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.location.Address;

import java.time.ZonedDateTime;

public class AccommodationProviderDto extends BaseEntityDto {
    private final String name;
    private final String description;
    private final String email;
    private final String phone;
    private final Address address;

    public AccommodationProviderDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String description, String email, String phone, Address address) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
