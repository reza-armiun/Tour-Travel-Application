package razarm.tosan.repository.domain.location;

import razarm.tosan.repository.domain.BaseEntity;

import java.time.Instant;
public class Address extends BaseEntity {

    private final String street;
    private final String postalCode;
    private final City city;


    public Address(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String street, String postalCode, City city) {
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

    public City getCity() {
        return city;
    }

    @Override
    public Address cloneWithId(String id) {
        return new Address(id, createdAt, modifiedAt, createdBy, modifiedBy, street, postalCode, city);
    }


    public static final class AddressBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String street;
        private String postalCode;
        private City city;

        private AddressBuilder() {
        }

        public static AddressBuilder anAddress() {
            return new AddressBuilder();
        }

        public AddressBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AddressBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AddressBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AddressBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AddressBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder city(City city) {
            this.city = city;
            return this;
        }

        public Address build() {
            return new Address(id, createdAt, modifiedAt, createdBy, modifiedBy, street, postalCode, city);
        }
    }


    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city=" + city +
                '}';
    }
}
