package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;

import java.time.ZonedDateTime;

public class TravelerDto extends BaseEntityDto {
    private final String name;
    private final String email;
    private final Long nationalId;
    private final String phone;
    //Add PassportNo
    private final AddressDto address;

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
}
