package razarm.tosan.repository.domain.food;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Orderable;
import razarm.tosan.repository.domain.tour.SchedulePlan;

import java.math.BigInteger;
import java.time.Instant;
import java.util.StringJoiner;

public class FoodOrder extends BaseEntity implements Orderable {
    private final Instant date;
    private final Integer discount;
    private final Food food;
    private final SchedulePlan schedulePlan;


    public FoodOrder(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Instant date, Integer discount, Food food, SchedulePlan schedulePlan) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.discount = discount;
        this.food = food;
        this.schedulePlan = schedulePlan;
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

    public SchedulePlan getSchedulePlan() {
        return schedulePlan;
    }

    @Override
    public BigInteger calculatePrice() {
        return food.getPrice() != null ? food.getPrice() : new BigInteger("0");
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
    public FoodOrder cloneWithId(String id) {
        return new FoodOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, food, schedulePlan);
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
        private SchedulePlan schedulePlan;

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

        public FoodOrderBuilder schedulePlan(SchedulePlan schedulePlan) {
            this.schedulePlan = schedulePlan;
            return this;
        }

        public FoodOrder build() {
            return new FoodOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, food, schedulePlan);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FoodOrder.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("date=" + date)
                .add("discount=" + discount)
                .add("food=" + food)
                .add("schedulePlan=" + schedulePlan)
                .toString();
    }
}
