package razarm.tosan.controller.dto.food;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.Priceable;
import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.food.FoodType;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodDto extends BaseEntityDto implements Priceable {
    private  String name;
    private  FoodType type;
    private  String [] ingredients;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private  BigInteger price;
    private  Long cookTime;
    private  FoodProviderDto provider;

    public FoodDto() {}

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


    public void setName(String name) {
        this.name = name;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public void setCookTime(Long cookTime) {
        this.cookTime = cookTime;
    }

    public void setProvider(FoodProviderDto provider) {
        this.provider = provider;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", FoodDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("type=" + type)
                .add("ingredients=" + Arrays.toString(ingredients))
                .add("price=" + price)
                .add("cookTime=" + cookTime)
                .add("provider=" + provider)
                .toString();
    }
}
