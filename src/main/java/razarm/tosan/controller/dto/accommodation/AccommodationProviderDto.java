package razarm.tosan.controller.dto.accommodation;

import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccommodationProviderDto extends BaseEntityDto {
    private  String name;
    private  String description;
    private  String email;
    private  String phone;
    private  AddressDto address;

    public AccommodationProviderDto() {}
    public AccommodationProviderDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String description, String email, String phone, AddressDto address) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public static final class AccommodationProviderDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String description;
        private String email;
        private String phone;
        private AddressDto address;

        private AccommodationProviderDtoBuilder() {
        }

        public static AccommodationProviderDtoBuilder anAccommodationProviderDto() {
            return new AccommodationProviderDtoBuilder();
        }

        public AccommodationProviderDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AccommodationProviderDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccommodationProviderDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AccommodationProviderDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccommodationProviderDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccommodationProviderDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AccommodationProviderDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public AccommodationProviderDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccommodationProviderDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public AccommodationProviderDtoBuilder address(AddressDto address) {
            this.address = address;
            return this;
        }

        public AccommodationProviderDto build() {
            return new AccommodationProviderDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, description, email, phone, address);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AccommodationProviderDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .add("address=" + address)
                .toString();
    }
}
