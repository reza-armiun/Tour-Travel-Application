package razarm.tosan.controller.dto.address;


import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto extends BaseEntityDto {
    private  String street;
    private  String postalCode;
    private  CityDto city;

    public AddressDto() {}

    public AddressDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String street, String postalCode, CityDto city) {
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

    public CityDto getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public static final class AddressDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String street;
        private String postalCode;
        private CityDto city;

        private AddressDtoBuilder() {
        }

        public static AddressDtoBuilder anAddressDto() {
            return new AddressDtoBuilder();
        }

        public AddressDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AddressDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AddressDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AddressDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AddressDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AddressDtoBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressDtoBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressDtoBuilder city(CityDto city) {
            this.city = city;
            return this;
        }

        public AddressDto build() {
            return new AddressDto(id, createdAt, modifiedAt, createdBy, modifiedBy, street, postalCode, city);
        }
    }

    @Override
    public String toString() {
        return "AddressDto{" +
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
