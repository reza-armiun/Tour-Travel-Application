package razarm.tosan.repository.domain.location;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.utility.AppCollections;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

public class Country extends BaseEntity implements Serializable {
    private final String name;
    private final String countryCode;

    private final Set<City> cities ;

    public Country(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String countryCode, Set<City> cities) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.countryCode = countryCode;
        this.cities = AppCollections.unmodifiableSet(cities);
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Set<City> getCities() {
        return cities;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new Country(id, createdAt, modifiedAt, createdBy, modifiedBy, name, countryCode, cities);
    }


    public static final class CountryBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String countryCode;
        private Set<City> cities ;

        private CountryBuilder() {
        }

        public static CountryBuilder aCountry() {
            return new CountryBuilder();
        }

        public CountryBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CountryBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CountryBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CountryBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CountryBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CountryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CountryBuilder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public CountryBuilder cities(Set<City> cities) {
            this.cities = cities;
            return this;
        }

        public Country build() {
            return new Country(id, createdAt, modifiedAt, createdBy, modifiedBy, name, countryCode, cities);
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
