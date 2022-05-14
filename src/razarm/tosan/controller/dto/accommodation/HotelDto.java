package razarm.tosan.controller.dto.accommodation;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.repository.domain.accommodation.AccommodationType;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class HotelDto extends AccommodationDto {
    private final Integer floor;
    private final Integer room;
    private final AccommodationType type = AccommodationType.HOTEL;


    public HotelDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, BigInteger price, Long time, AddressDto addressDto, AccommodationProviderDto accommodationProvider, Integer floor, Integer room) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, AccommodationType.HOTEL, price, time, addressDto, accommodationProvider);
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
        private Integer floor;
        private Integer room;

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

        public HotelDtoBuilder type(AccommodationType type) {
            this.type = type;
            return this;
        }

        public HotelDtoBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public HotelDtoBuilder time(Long time) {
            this.time = time;
            return this;
        }

        public HotelDtoBuilder addressDto(AddressDto addressDto) {
            this.addressDto = addressDto;
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

        public HotelDto build() {
            HotelDto hotelDto = new HotelDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, price, time, addressDto, accommodationProvider, floor, room);
            return hotelDto;
        }
    }
}
