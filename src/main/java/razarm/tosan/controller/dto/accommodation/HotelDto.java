package razarm.tosan.controller.dto.accommodation;

import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.repository.domain.accommodation.AccommodationType;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelDto extends AccommodationDto {
    private  Integer floor;
    private  Integer room;
    private  AccommodationType type = AccommodationType.HOTEL;

    public HotelDto() {}

    public HotelDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, BigInteger price, ZonedDateTime checkIn, ZonedDateTime checkOut, AddressDto address, AccommodationProviderDto accommodationProvider, Integer floor, Integer room, AccommodationType type1) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, AccommodationType.HOTEL, price, checkIn, checkOut, address, accommodationProvider);
        this.floor = floor;
        this.room = room;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getRoom() {
        return room;
    }

    @Override
    public AccommodationType getType() {
        return type;
    }


    public static final class HotelDtoBuilder {
        protected  String id;
        protected ZonedDateTime createdAt;
        protected  ZonedDateTime modifiedAt;
        protected  String createdBy;
        protected  String modifiedBy;
        private  String name;
        //    @JsonFormat(shape = JsonFormat.Shape.STRING)
        private BigInteger price;
        private ZonedDateTime checkIn;
        private ZonedDateTime checkOut;
        private AddressDto address;
        private AccommodationProviderDto accommodationProvider;
        private  Integer floor;
        private  Integer room;
        private  AccommodationType type = AccommodationType.HOTEL;

        private HotelDtoBuilder() {
        }

        public static HotelDtoBuilder aHotelDto() {
            return new HotelDtoBuilder();
        }

        public HotelDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public HotelDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public HotelDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public HotelDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public HotelDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public HotelDtoBuilder name(String name) {
            this.name = name;
            return this;
        }


        public HotelDtoBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public HotelDtoBuilder checkIn(ZonedDateTime checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public HotelDtoBuilder checkOut(ZonedDateTime checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public HotelDtoBuilder address(AddressDto address) {
            this.address = address;
            return this;
        }

        public HotelDtoBuilder accommodationProvider(AccommodationProviderDto accommodationProvider) {
            this.accommodationProvider = accommodationProvider;
            return this;
        }

        public HotelDtoBuilder floor(Integer floor) {
            this.floor = floor;
            return this;
        }

        public HotelDtoBuilder room(Integer room) {
            this.room = room;
            return this;
        }

        public HotelDtoBuilder type(AccommodationType type) {
            this.type = type;
            return this;
        }

        public HotelDto build() {
            return new HotelDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, price, checkIn, checkOut, address, accommodationProvider, floor, room, null);
        }
    }
}
