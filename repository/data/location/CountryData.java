package razarm.tosan.repository.data.location;

import razarm.tosan.repository.data.BaseEntityData;

import java.io.Serializable;
import java.time.Instant;

public class CountryData extends BaseEntityData implements Serializable {
    private final String name;
    private final String countryCode;

    public CountryData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String countryCode) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new CountryData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, countryCode);
    }


    public static final class CountryDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String countryCode;

        private CountryDataBuilder() {
        }

        public static CountryDataBuilder aCountryData() {
            return new CountryDataBuilder();
        }

        public CountryDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CountryDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CountryDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CountryDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CountryDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CountryDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CountryDataBuilder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public CountryData build() {
            return new CountryData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, countryCode);
        }
    }
}
