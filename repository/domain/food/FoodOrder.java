package razarm.tosan.repository.domain.food;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Orderable;

import java.math.BigInteger;
import java.time.Instant;

public class FoodOrder extends BaseEntity implements Orderable {
    private final Instant date;
    private final Integer discount;
    private final Food food;


    public FoodOrder(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Instant date, Integer discount, Food food) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.discount = discount;
        this.food = food;
    }

    public Instant getDate() {
        return date;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public BigInteger calculatePrice() {
        return null;
    }

    @Override
    public Integer discountRate() {
        return null;
    }

    @Override
    public Integer countItems() {
        return null;
    }

    @Override
    public BigInteger calculateTaxPrice(int tax) {
        return null;
    }

    @Override
    public Long estimateTime() {
        return null;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new FoodOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, food);
    }


    public static final class FoodOrderBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private Instant date;
        private Integer discount;
        private Food food;

        private FoodOrderBuilder() {
        }

        public static FoodOrderBuilder aFoodOrder() {
            return new FoodOrderBuilder();
        }

        public FoodOrderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodOrderBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodOrderBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodOrderBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodOrderBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodOrderBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public FoodOrderBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public FoodOrderBuilder food(Food food) {
            this.food = food;
            return this;
        }

        public FoodOrder build() {
            return new FoodOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, food);
        }
    }
}
