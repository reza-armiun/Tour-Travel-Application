package razarm.tosan.controller.dto.food;

import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;

public class FoodOrderDto extends BaseEntityDto {
    private final ZonedDateTime date;
    private final Integer discount;
    private final FoodDto food;

    public FoodOrderDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, ZonedDateTime date, Integer discount, FoodDto food) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.discount = discount;
        this.food = food;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Integer getDiscount() {
        return discount;
    }

    public FoodDto getFood() {
        return food;
    }


    public static final class FoodOrderDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private ZonedDateTime date;
        private Integer discount;
        private FoodDto food;

        private FoodOrderDtoBuilder() {
        }

        public static FoodOrderDtoBuilder aFoodOrderDto() {
            return new FoodOrderDtoBuilder();
        }

        public FoodOrderDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodOrderDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodOrderDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodOrderDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodOrderDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodOrderDtoBuilder date(ZonedDateTime date) {
            this.date = date;
            return this;
        }

        public FoodOrderDtoBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public FoodOrderDtoBuilder food(FoodDto food) {
            this.food = food;
            return this;
        }

        public FoodOrderDto build() {
            return new FoodOrderDto(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, food);
        }
    }
}
