package razarm.tosan.repository.domain.location;

import razarm.tosan.repository.domain.BaseEntity;

import java.io.Serializable;
import java.time.Instant;

public class City extends BaseEntity implements Serializable {
    private final String name ;
    private final Integer zipCode;
    private transient final Country country;

    public City(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Integer zipCode, Country country) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new City(id, createdAt, modifiedAt, createdBy, modifiedBy, name, zipCode, country);
    }


    public static final class CityBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name ;
        private Integer zipCode;
        private Country country;

        private CityBuilder() {
        }

        public static CityBuilder aCity() {
            return new CityBuilder();
        }

        public CityBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CityBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CityBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CityBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CityBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CityBuilder zipCode(Integer zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public CityBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public City build() {
            return new City(id, createdAt, modifiedAt, createdBy, modifiedBy, name, zipCode, country);
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", name='" + name + '\'' +
                ", zipCode=" + zipCode +
                ", country=" + country +
                '}';
    }
}
