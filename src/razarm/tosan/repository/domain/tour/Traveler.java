package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Booking;
import razarm.tosan.repository.domain.location.Address;

import java.time.Instant;

public class Traveler extends BaseEntity {
    private final String name;
    private final String email;
    private final Long nationalId;
    private final String phone;
    private final Address address;
    private final Booking booking;


    public Traveler(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Address address, String email, String name, Long nationalId, String phone, Booking booking) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.address = address;
        this.email = email;
        this.name = name;
        this.nationalId = nationalId;
        this.phone = phone;
        this.booking = booking;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new Traveler(id, createdAt, modifiedAt, createdBy, modifiedBy, address, email, name, nationalId, phone, booking);
    }


    public static final class TravelerBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private Address address;
        private String email;
        private String name;
        private Long nationalId;
        private String phone;
        private Booking booking;

        private TravelerBuilder() {
        }

        public static TravelerBuilder aTraveler() {
            return new TravelerBuilder();
        }

        public TravelerBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TravelerBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TravelerBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TravelerBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TravelerBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TravelerBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public TravelerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TravelerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TravelerBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public TravelerBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public TravelerBuilder booking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Traveler build() {
            return new Traveler(id, createdAt, modifiedAt, createdBy, modifiedBy, address, email, name, nationalId, phone, booking);
        }
    }
}
