package razarm.tosan.controller.dto.accommodation;

import com.fasterxml.jackson.annotation.*;
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
public class AccommodationDto extends BaseEntityDto { //TODO make it abstract
    private  String name;
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private  AccommodationType type;
    private  BigInteger price;
    private  Long time;
    private  AddressDto addressDto;
    private  AccommodationProviderDto accommodationProvider;


    public AccommodationDto() {}
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


    public void setName(String name) {
        this.name = name;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public void setAccommodationProvider(AccommodationProviderDto accommodationProvider) {
        this.accommodationProvider = accommodationProvider;
    }

    public static final class AccommodationDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private AccommodationType type;
        private BigInteger price;
        private Long time;
        private AddressDto addressDto;
        private AccommodationProviderDto accommodationProvider;

        private AccommodationDtoBuilder() {
        }

        public static AccommodationDtoBuilder anAccommodationDto() {
            return new AccommodationDtoBuilder();
        }

        public AccommodationDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AccommodationDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccommodationDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AccommodationDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccommodationDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccommodationDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AccommodationDtoBuilder type(AccommodationType type) {
            this.type = type;
            return this;
        }

        public AccommodationDtoBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public AccommodationDtoBuilder time(Long time) {
            this.time = time;
            return this;
        }

        public AccommodationDtoBuilder addressDto(AddressDto addressDto) {
            this.addressDto = addressDto;
            return this;
        }

        public AccommodationDtoBuilder accommodationProvider(AccommodationProviderDto accommodationProvider) {
            this.accommodationProvider = accommodationProvider;
            return this;
        }

        public AccommodationDto build() {
            return new AccommodationDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, price, time, addressDto, accommodationProvider);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AccommodationDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("type=" + type)
                .add("price=" + price)
                .add("time=" + time)
                .add("addressDto=" + addressDto)
                .add("accommodationProvider=" + accommodationProvider)
                .toString();
    }
}
