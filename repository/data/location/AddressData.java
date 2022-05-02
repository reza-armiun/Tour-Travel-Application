package razarm.tosan.repository.data.location;

import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;

public class AddressData extends BaseEntityData {
    private final String street;
    private final String postalCode;
    private final CityData city;

    public AddressData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String street, String postalCode, CityData city) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public CityData getCity() {
        return city;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new AddressData(id, createdAt, modifiedAt, createdBy, modifiedBy, street, postalCode, city);
    }


    public static final class AddressDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String street;
        private String postalCode;
        private CityData city;

        private AddressDataBuilder() {
        }

        public static AddressDataBuilder anAddressData() {
            return new AddressDataBuilder();
        }

        public AddressDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AddressDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AddressDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AddressDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AddressDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AddressDataBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressDataBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressDataBuilder city(CityData city) {
            this.city = city;
            return this;
        }

        public AddressData build() {
            return new AddressData(id, createdAt, modifiedAt, createdBy, modifiedBy, street, postalCode, city);
        }
    }
}
