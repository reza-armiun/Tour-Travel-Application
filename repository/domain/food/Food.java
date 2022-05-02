package razarm.tosan.repository.domain.food;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Costable;
import razarm.tosan.repository.domain.Timeable;
import razarm.tosan.utility.AppCollections;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;


public class Food extends BaseEntity
        implements Costable, Timeable {
    private final String name;
    private final FoodType type;
    private final String [] ingredients;
    private final BigInteger price;
    private final Long cookTime;
    private final FoodProvider provider;
    private final Set<FoodOrder> foodOrders;

    public Food(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, FoodType type, String[] ingredients, BigInteger price, Long cookTime, FoodProvider provider, Set<FoodOrder> foodOrders) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.price = price;
        this.cookTime = cookTime;
        this.provider = provider;
        this.foodOrders = AppCollections.unmodifiableSet(foodOrders);
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

    public FoodProvider getProvider() {
        return provider;
    }

    public Set<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    @Override
    public BigInteger calculatePrice() {
        return null;
    }

    @Override
    public Long estimateTime() {
        return null;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new Food(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, ingredients, price, cookTime, provider, foodOrders);
    }


    public static final class FoodBuilder {
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
        private FoodProvider provider;
        private Set<FoodOrder> foodOrders;

        private FoodBuilder() {
        }

        public static FoodBuilder aFood() {
            return new FoodBuilder();
        }

        public FoodBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FoodBuilder type(FoodType type) {
            this.type = type;
            return this;
        }

        public FoodBuilder ingredients(String[] ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public FoodBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public FoodBuilder cookTime(Long cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        public FoodBuilder provider(FoodProvider provider) {
            this.provider = provider;
            return this;
        }

        public FoodBuilder foodOrders(Set<FoodOrder> foodOrders) {
            this.foodOrders = foodOrders;
            return this;
        }

        public Food build() {
            return new Food(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, ingredients, price, cookTime, provider, foodOrders);
        }
    }
}
