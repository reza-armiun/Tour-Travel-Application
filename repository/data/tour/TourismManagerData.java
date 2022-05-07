package razarm.tosan.repository.data.tour;


import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.data.location.AddressData;
import razarm.tosan.repository.domain.location.Address;

import java.time.Instant;

public class TourismManagerData extends BaseEntityData {

    private final String name;
    private final String email;
    private final String phone;
    private final AddressData address;
    private final Long nationalId;

    public TourismManagerData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String email, String phone, AddressData address, Long nationalId) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nationalId = nationalId;
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


    public Long getNationalId() {
        return nationalId;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new TourismManagerData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, email, phone, address, nationalId);
    }

    public AddressData getAddress() {
        return address;
    }


    public static final class TourismManagerDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String email;
        private String phone;
        private AddressData address;
        private Long nationalId;

        private TourismManagerDataBuilder() {
        }

        public static TourismManagerDataBuilder aTourismManagerData() {
            return new TourismManagerDataBuilder();
        }

        public TourismManagerDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TourismManagerDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TourismManagerDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TourismManagerDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TourismManagerDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TourismManagerDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TourismManagerDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TourismManagerDataBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public TourismManagerDataBuilder address(AddressData address) {
            this.address = address;
            return this;
        }

        public TourismManagerDataBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public TourismManagerData build() {
            return new TourismManagerData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, email, phone, address, nationalId);
        }
    }
}
