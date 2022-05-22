package razarm.tosan.controller.dto.address;


import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDto extends BaseEntityDto {
    private  String name ;
    private  Integer zipCode;
    private   CountryDto country;


    public CityDto() {}

    public CityDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, Integer zipCode, CountryDto country) {
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

    public CountryDto getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public static final class CityDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name ;
        private Integer zipCode;
        private CountryDto country;

        private CityDtoBuilder() {
        }

        public static CityDtoBuilder aCityDto() {
            return new CityDtoBuilder();
        }

        public CityDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CityDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CityDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CityDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CityDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CityDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CityDtoBuilder zipCode(Integer zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public CityDtoBuilder country(CountryDto country) {
            this.country = country;
            return this;
        }

        public CityDto build() {
            return new CityDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, zipCode, country);
        }
    }
}
