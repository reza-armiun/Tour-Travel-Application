package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class TourismManager extends BaseEntity {
    private final String name;
    private final String email;
    private final String phone;
    private final Address address;
    private final Long nationalId;

    private final Set<Tour> tours ;

    public TourismManager(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String email, String phone, Address address, Long nationalId, Set<Tour> tours) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nationalId = nationalId;
        this.tours = AppCollections.unmodifiableSet(tours);
    }

    public String getName() {
        return name;
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

    public Long getNationalId() {
        return nationalId;
    }

    public Set<Tour> getTours() {
        return tours;
    }


    @Override
    public BaseEntity cloneWithId(String id) {
        return new TourismManager(id, createdAt, modifiedAt, createdBy, modifiedBy, name, email, phone, address, nationalId, tours);
    }


    public static final class TourismManagerBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String email;
        private String phone;
        private Address address;
        private Long nationalId;
        private Set<Tour> tours ;

        private TourismManagerBuilder() {
        }

        public static TourismManagerBuilder aTourismManager() {
            return new TourismManagerBuilder();
        }

        public TourismManagerBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TourismManagerBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TourismManagerBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TourismManagerBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TourismManagerBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TourismManagerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TourismManagerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TourismManagerBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public TourismManagerBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public TourismManagerBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public TourismManagerBuilder tours(Set<Tour> tours) {
            this.tours = tours;
            return this;
        }

        public TourismManager build() {
            return new TourismManager(id, createdAt, modifiedAt, createdBy, modifiedBy, name, email, phone, address, nationalId, tours);
        }
    }
}
