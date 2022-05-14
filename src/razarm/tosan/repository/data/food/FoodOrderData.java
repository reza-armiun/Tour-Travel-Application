package razarm.tosan.repository.data.food;


import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;

public class FoodOrderData extends BaseEntityData {
    private final Instant date;
    private final Integer discount;
    private final FoodData food;

    public FoodOrderData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Instant date, Integer discount, FoodData food) {
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

    public FoodData getFood() {
        return food;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new FoodOrderData(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, food);
    }


    public static final class FoodOrderDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private Instant date;
        private Integer discount;
        private FoodData food;

        private FoodOrderDataBuilder() {
        }

        public static FoodOrderDataBuilder aFoodOrderData() {
            return new FoodOrderDataBuilder();
        }

        public FoodOrderDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodOrderDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodOrderDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodOrderDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodOrderDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodOrderDataBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public FoodOrderDataBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public FoodOrderDataBuilder food(FoodData food) {
            this.food = food;
            return this;
        }

        public FoodOrderData build() {
            return new FoodOrderData(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, food);
        }
    }
}
