package razarm.tosan.repository.data.accommodation;

import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;

public class AccommodationProviderData extends BaseEntityData {
    private final String name;
    private final String description;
    private final String email;
    private final String phone;
    private final String addressId;


    public AccommodationProviderData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String description, String email, String phone, String addressId) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new AccommodationProviderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, description, email, phone, addressId);
    }


    public static final class AccommodationProviderDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String description;
        private String email;
        private String phone;
        private String addressId;

        private AccommodationProviderDataBuilder() {
        }

        public static AccommodationProviderDataBuilder anAccommodationProviderData() {
            return new AccommodationProviderDataBuilder();
        }

        public AccommodationProviderDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AccommodationProviderDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccommodationProviderDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AccommodationProviderDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccommodationProviderDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccommodationProviderDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AccommodationProviderDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public AccommodationProviderDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccommodationProviderDataBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public AccommodationProviderDataBuilder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public AccommodationProviderData build() {
            return new AccommodationProviderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, description, email, phone, addressId);
        }
    }
}
