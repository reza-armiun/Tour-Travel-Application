package razarm.tosan.controller.dto.auth;

import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;

public class UserDto extends BaseEntityDto {
    private final String name;
    private final String username;
    private final String phone;
    private final String email;
    private final Long nationalId;


    public UserDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String username, String phone, String email, Long nationalId) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.nationalId = nationalId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }


    public static final class UserDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String username;
        private String phone;
        private String email;
        private Long nationalId;

        private UserDtoBuilder() {
        }

        public static UserDtoBuilder anUserDto() {
            return new UserDtoBuilder();
        }

        public UserDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public UserDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public UserDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public UserDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserDtoBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDtoBuilder nationalId(Long nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public UserDto build() {
            return new UserDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, username, phone, email, nationalId);
        }
    }
}
