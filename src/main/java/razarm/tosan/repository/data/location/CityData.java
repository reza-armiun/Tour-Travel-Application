package razarm.tosan.repository.data.location;

import razarm.tosan.repository.data.BaseEntityData;

import java.io.Serializable;
import java.time.Instant;

public class CityData extends BaseEntityData implements Serializable {
    private final String name ;
    private final Integer zipCode;
    private final CountryData country;

    public CityData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Integer zipCode, CountryData country) {
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

    public CountryData getCountry() {
        return country;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new CityData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, zipCode, country);
    }


    public static final class CityDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name ;
        private Integer zipCode;
        private CountryData country;

        private CityDataBuilder() {
        }

        public static CityDataBuilder aCityData() {
            return new CityDataBuilder();
        }

        public CityDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CityDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CityDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CityDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CityDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CityDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CityDataBuilder zipCode(Integer zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public CityDataBuilder country(CountryData country) {
            this.country = country;
            return this;
        }

        public CityData build() {
            return new CityData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, zipCode, country);
        }
    }


}
