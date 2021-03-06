package razarm.tosan.controller.dto.food;


import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;
import java.util.Set;

public class FoodProviderDto extends BaseEntityDto {
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final String description;
    private final Set<FoodDto> foods;

    public FoodProviderDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String address, String phone, String email, String description, Set<FoodDto> foods) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
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

    public Set<FoodDto> getFoods() {
        return foods;
    }


    public static final class FoodProviderDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String address;
        private String phone;
        private String email;
        private String description;
        private Set<FoodDto> foods;

        private FoodProviderDtoBuilder() {
        }

        public static FoodProviderDtoBuilder aFoodProviderDto() {
            return new FoodProviderDtoBuilder();
        }

        public FoodProviderDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodProviderDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodProviderDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodProviderDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodProviderDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodProviderDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FoodProviderDtoBuilder address(String address) {
            this.address = address;
            return this;
        }

        public FoodProviderDtoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public FoodProviderDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public FoodProviderDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FoodProviderDtoBuilder foods(Set<FoodDto> foods) {
            this.foods = foods;
            return this;
        }

        public FoodProviderDto build() {
            return new FoodProviderDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, phone, email, description, foods);
        }
    }
}
