package razarm.tosan.controller.dto.transport;


import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

public class VehicleProviderDto extends BaseEntityDto {
    private  String name;
    private  String phone;
    private  String email;
    private  String description;
    private  AddressDto address;

    public VehicleProviderDto() {}

    public VehicleProviderDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String phone, String email, String description, AddressDto address) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public AddressDto getAddress() {
        return address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public static final class VehicleProviderDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String phone;
        private String email;
        private String description;
        private AddressDto address;

        private VehicleProviderDtoBuilder() {
        }

        public static VehicleProviderDtoBuilder aVehicleProviderDto() {
            return new VehicleProviderDtoBuilder();
        }

        public VehicleProviderDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VehicleProviderDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VehicleProviderDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public VehicleProviderDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public VehicleProviderDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public VehicleProviderDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VehicleProviderDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public VehicleProviderDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public VehicleProviderDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public VehicleProviderDtoBuilder address(AddressDto address) {
            this.address = address;
            return this;
        }

        public VehicleProviderDto build() {
            return new VehicleProviderDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, phone, email, description, address);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VehicleProviderDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("phone='" + phone + "'")
                .add("email='" + email + "'")
                .add("description='" + description + "'")
                .add("address=" + address)
                .toString();
    }
}
