package razarm.tosan.repository.domain.accommodation;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.location.Address;

import java.math.BigInteger;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Set;

public class Hotel extends  Accommodation{
    private final Integer floor;
    private final Integer room;
    private final AccommodationType type = AccommodationType.HOTEL;


    public Hotel(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Address address, BigInteger price, ZonedDateTime checkIn, ZonedDateTime checkOut, AccommodationProvider accommodationProvider, Set<AccommodationOrder> accommodationOrders, Integer floor, Integer room) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, AccommodationType.HOTEL, address, price, checkIn, checkOut, accommodationProvider, accommodationOrders);
        this.floor = floor;
        this.room = room;
    }

    @Override
    public BigInteger calculatePrice() {
        return null;
    }

    @Override
    public Long estimateTime() {
        return null;
    }

    @Override
    public AccommodationType getType() {
        return type;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
       return new Hotel(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, price, checkIn, checkOut, accommodationProvider, accommodationOrders, floor, room);
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getRoom() {
        return room;
    }


    public static final class HotelBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected Address address;
        protected BigInteger price;
        protected ZonedDateTime checkIn;
        protected ZonedDateTime checkOut;
        protected AccommodationProvider accommodationProvider;
        protected Set<AccommodationOrder> accommodationOrders;
        private Integer floor;
        private Integer room;
        private AccommodationType type = AccommodationType.HOTEL;

        private HotelBuilder() {
        }

        public static HotelBuilder aHotel() {
            return new HotelBuilder();
        }

        public HotelBuilder id(String id) {
            this.id = id;
            return this;
        }

        public HotelBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public HotelBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public HotelBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public HotelBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public HotelBuilder name(String name) {
            this.name = name;
            return this;
        }



        public HotelBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public HotelBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public HotelBuilder checkIn(ZonedDateTime checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public HotelBuilder checkOut(ZonedDateTime checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public HotelBuilder accommodationProvider(AccommodationProvider accommodationProvider) {
            this.accommodationProvider = accommodationProvider;
            return this;
        }

        public HotelBuilder accommodationOrders(Set<AccommodationOrder> accommodationOrders) {
            this.accommodationOrders = accommodationOrders;
            return this;
        }

        public HotelBuilder floor(Integer floor) {
            this.floor = floor;
            return this;
        }

        public HotelBuilder room(Integer room) {
            this.room = room;
            return this;
        }

        public HotelBuilder type(AccommodationType type) {
            this.type = type;
            return this;
        }

        public Hotel build() {
            return new Hotel(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, price, checkIn, checkOut, accommodationProvider, accommodationOrders, floor, room);
        }
    }
}
