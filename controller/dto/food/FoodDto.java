package razarm.tosan.controller.dto.food;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.food.FoodType;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class FoodDto extends BaseEntityDto {
    private final String name;
    private final FoodType type;
    private final String [] ingredients;
    private final BigInteger price;
    private final Long cookTime;
    private final FoodProviderDto provider;

    public FoodDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, FoodType type, String[] ingredients, BigInteger price, Long cookTime, FoodProviderDto provider) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.price = price;
        this.cookTime = cookTime;
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public FoodType getType() {
        return type;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public BigInteger getPrice() {
        return price;
    }

    public Long getCookTime() {
        return cookTime;
    }

    public FoodProviderDto getProvider() {
        return provider;
    }


    public static final class FoodDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private FoodType type;
        private String [] ingredients;
        private BigInteger price;
        private Long cookTime;
        private FoodProviderDto provider;

        private FoodDtoBuilder() {
        }

        public static FoodDtoBuilder aFoodDto() {
            return new FoodDtoBuilder();
        }

        public FoodDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FoodDtoBuilder type(FoodType type) {
            this.type = type;
            return this;
        }

        public FoodDtoBuilder ingredients(String[] ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public FoodDtoBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public FoodDtoBuilder cookTime(Long cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        public FoodDtoBuilder provider(FoodProviderDto provider) {
            this.provider = provider;
            return this;
        }

        public FoodDto build() {
            return new FoodDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, ingredients, price, cookTime, provider);
        }
    }
}
