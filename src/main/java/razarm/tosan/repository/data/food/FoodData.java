package razarm.tosan.repository.data.food;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.food.FoodType;

import java.math.BigInteger;
import java.time.Instant;

public class FoodData extends BaseEntityData {
    private final String name;
    private final FoodType type;
    private final String [] ingredients;
    private final BigInteger price;
    private final Long cookTime;
    private final FoodProviderData provider;

    public FoodData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, FoodType type, String[] ingredients, BigInteger price, Long cookTime, FoodProviderData provider) {
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

    public FoodProviderData getProvider() {
        return provider;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new FoodData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, ingredients, price, cookTime, provider);
    }


    public static final class FoodDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private FoodType type;
        private String [] ingredients;
        private BigInteger price;
        private Long cookTime;
        private FoodProviderData provider;

        private FoodDataBuilder() {
        }

        public static FoodDataBuilder aFoodData() {
            return new FoodDataBuilder();
        }

        public FoodDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FoodDataBuilder type(FoodType type) {
            this.type = type;
            return this;
        }

        public FoodDataBuilder ingredients(String[] ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public FoodDataBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public FoodDataBuilder cookTime(Long cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        public FoodDataBuilder provider(FoodProviderData provider) {
            this.provider = provider;
            return this;
        }

        public FoodData build() {
            return new FoodData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, ingredients, price, cookTime, provider);
        }
    }
}
