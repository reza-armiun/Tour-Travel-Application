package razarm.tosan.repository.data.accommodation;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.accommodation.AccommodationType;
import razarm.tosan.repository.domain.location.Address;

import java.math.BigInteger;
import java.time.Instant;

public class HotelData extends AccommodationData {
    private final Integer floor;
    private final Integer room;
    private final AccommodationType type = AccommodationType.HOTEL;


    public HotelData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Address address, BigInteger price, Long time, AccommodationProviderData accommodationProvider, Integer floor, Integer room) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, AccommodationType.HOTEL, address, price, time, accommodationProvider);
        this.floor = floor;
        this.room = room;
    }

    @Override
    public AccommodationType getType() {
        return type;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new HotelData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, price, time, accommodationProvider, floor, room);
    }


    public static final class HotelDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected Address address;
        protected BigInteger price;
        protected Long time;
        protected AccommodationProviderData accommodationProvider;
        private Integer floor;
        private Integer room;
        private AccommodationType type = AccommodationType.HOTEL;

        private HotelDataBuilder() {
        }

        public static HotelDataBuilder aHotelData() {
            return new HotelDataBuilder();
        }

        public HotelDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public HotelDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public HotelDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public HotelDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public HotelDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public HotelDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HotelDataBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public HotelDataBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public HotelDataBuilder time(Long time) {
            this.time = time;
            return this;
        }

        public HotelDataBuilder accommodationProvider(AccommodationProviderData accommodationProvider) {
            this.accommodationProvider = accommodationProvider;
            return this;
        }

        public HotelDataBuilder floor(Integer floor) {
            this.floor = floor;
            return this;
        }

        public HotelDataBuilder room(Integer room) {
            this.room = room;
            return this;
        }

        public HotelDataBuilder type(AccommodationType type) {
            this.type = type;
            return this;
        }

        public HotelData build() {
            HotelData hotelData = new HotelData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, price, time, accommodationProvider, floor, room);
            return hotelData;
        }
    }
}
