package razarm.tosan.controller.dto.accommodation;

import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.accommodation.AccommodationType;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class AccommodationDto extends BaseEntityDto {
    private final String name;
    private final AccommodationType type;
    private final BigInteger price;
    private final Long time;
    private final AddressDto addressDto;
    private final AccommodationProviderDto accommodationProvider;


    public AccommodationDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, AccommodationType type, BigInteger price, Long time, AddressDto addressDto, AccommodationProviderDto accommodationProvider) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.price = price;
        this.time = time;
        this.addressDto = addressDto;
        this.accommodationProvider = accommodationProvider;
    }

    public String getName() {
        return name;
    }

    public AccommodationType getType() {
        return type;
    }

    public BigInteger getPrice() {
        return price;
    }

    public Long getTime() {
        return time;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public AccommodationProviderDto getAccommodationProvider() {
        return accommodationProvider;
    }
}
