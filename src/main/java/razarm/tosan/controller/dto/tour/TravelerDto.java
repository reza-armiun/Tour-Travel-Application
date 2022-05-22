package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;

import java.time.ZonedDateTime;

public class TravelerDto extends BaseEntityDto {
    private  String name;
    private  String email;
    private  Long nationalId;
    private  String phone;
    //Add PassportNo
    private  AddressDto address;


    public TravelerDto() {}
    public TravelerDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, AddressDto address, String email, String name, Long nationalId, String phone) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.address = address;
        this.email = email;
        this.name = name;
        this.nationalId = nationalId;
        this.phone = phone;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public static final class TravelerDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private AddressDto address;
        private String email;
        private String name;
        private Long nationalId;
        private String phone;

        private TravelerDtoBuilder() {
        }

        public static TravelerDtoBuilder aTravelerDto() {
            return new TravelerDtoBuilder();
        }

        public TravelerDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TravelerDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TravelerDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TravelerDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TravelerDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TravelerDtoBuilder address(AddressDto address) {
            this.address = address;
            return this;
        }

        public TravelerDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TravelerDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TravelerDtoBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public TravelerDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public TravelerDto build() {
            return new TravelerDto(id, createdAt, modifiedAt, createdBy, modifiedBy, address, email, name, nationalId, phone);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TravelerDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", nationalId=").append(nationalId);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
