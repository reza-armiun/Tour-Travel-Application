package razarm.tosan.repository.data.transport;


import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;

public class VehicleProviderData extends BaseEntityData {

    private final String name;
    private final String phone;
    private final String email;
    private final String description;
    private final String  addressId;

    public VehicleProviderData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String phone, String email, String description, String addressId) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getAddressId() {
        return addressId;
    }

    @Override
    public VehicleProviderData cloneWithId(String id) {
        return new VehicleProviderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, phone, email, description, addressId);
    }


    public static final class VehicleProviderDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String phone;
        private String email;
        private String description;
        private String  addressId;

        private VehicleProviderDataBuilder() {
        }

        public static VehicleProviderDataBuilder aVehicleProviderData() {
            return new VehicleProviderDataBuilder();
        }

        public VehicleProviderDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VehicleProviderDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VehicleProviderDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public VehicleProviderDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public VehicleProviderDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public VehicleProviderDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VehicleProviderDataBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public VehicleProviderDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public VehicleProviderDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public VehicleProviderDataBuilder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public VehicleProviderData build() {
            return new VehicleProviderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, phone, email, description, addressId);
        }
    }
}
