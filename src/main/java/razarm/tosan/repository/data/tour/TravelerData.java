package razarm.tosan.repository.data.tour;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.data.location.AddressData;

import java.time.Instant;

public class TravelerData extends BaseEntityData {

    private final String name;
    private final String email;
    private final AddressData address;
    private final Long nationalId;
    private final String phone;


    public TravelerData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String email, AddressData address, Long nationalId, String phone) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationalId = nationalId;
        this.phone = phone;
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

    public AddressData getAddress() {
        return address;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new TravelerData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, email, address, nationalId, phone);
    }


    public static final class TravelerDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String email;
        private AddressData address;
        private Long nationalId;
        private String phone;

        private TravelerDataBuilder() {
        }

        public static TravelerDataBuilder aTravelerData() {
            return new TravelerDataBuilder();
        }

        public TravelerDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TravelerDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TravelerDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TravelerDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TravelerDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TravelerDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TravelerDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TravelerDataBuilder address(AddressData address) {
            this.address = address;
            return this;
        }

        public TravelerDataBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public TravelerDataBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public TravelerData build() {
            return new TravelerData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, email, address, nationalId, phone);
        }
    }
}
