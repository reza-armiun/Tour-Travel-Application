package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;

import java.time.ZonedDateTime;

public class TourismManagerDto extends BaseEntityDto {
    private final String name;
    private final String email;
    private final String phone;
    private final AddressDto address;
    private final Long nationalId;

    public TourismManagerDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String email, String phone, AddressDto address, Long nationalId) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
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

    public Long getNationalId() {
        return nationalId;
    }


    public static final class TourismManagerDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String email;
        private String phone;
        private AddressDto address;
        private Long nationalId;

        private TourismManagerDtoBuilder() {
        }

        public static TourismManagerDtoBuilder aTourismManagerDto() {
            return new TourismManagerDtoBuilder();
        }

        public TourismManagerDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TourismManagerDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TourismManagerDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TourismManagerDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TourismManagerDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TourismManagerDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TourismManagerDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public TourismManagerDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public TourismManagerDtoBuilder address(AddressDto address) {
            this.address = address;
            return this;
        }

        public TourismManagerDtoBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public TourismManagerDto build() {
            return new TourismManagerDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, email, phone, address, nationalId);
        }
    }
}
