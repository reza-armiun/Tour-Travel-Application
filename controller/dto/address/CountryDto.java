package razarm.tosan.controller.dto.address;


import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;

public class CountryDto extends BaseEntityDto {
    private final String name;
    private final String countryCode;

    public CountryDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String countryCode) {
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


    public static final class CountryDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String countryCode;

        private CountryDtoBuilder() {
        }

        public static CountryDtoBuilder aCountryDto() {
            return new CountryDtoBuilder();
        }

        public CountryDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CountryDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CountryDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CountryDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CountryDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CountryDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CountryDtoBuilder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public CountryDto build() {
            return new CountryDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, countryCode);
        }
    }
}
