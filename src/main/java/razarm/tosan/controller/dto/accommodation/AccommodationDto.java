package razarm.tosan.controller.dto.accommodation;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;
import razarm.tosan.Priceable;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.accommodation.AccommodationType;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HotelDto.class, name = "HOTEL"),
})
@ToString
public class AccommodationDto extends BaseEntityDto implements Priceable { //TODO make it abstract
    private  String name;
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private  AccommodationType type;
    private  BigInteger price;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime checkIn;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime checkOut;
    private  AddressDto address;
    private  AccommodationProviderDto accommodationProvider;


    public AccommodationDto() {}

    public AccommodationDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, AccommodationType type, BigInteger price, ZonedDateTime checkIn, ZonedDateTime checkOut, AddressDto address, AccommodationProviderDto accommodationProvider) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.price = price;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.address = address;
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


    public AddressDto getAddress() {
        return address;
    }

    public AccommodationProviderDto getAccommodationProvider() {
        return accommodationProvider;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }


    public ZonedDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(ZonedDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public ZonedDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(ZonedDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public void setAccommodationProvider(AccommodationProviderDto accommodationProvider) {
        this.accommodationProvider = accommodationProvider;
    }




}

