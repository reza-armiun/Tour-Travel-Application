package razarm.tosan.repository.mapper.food;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.food.FoodOrderData;
import razarm.tosan.repository.domain.food.FoodOrder;

public class FoodOrderDataToFoodOrder implements Mapper<FoodOrderData, FoodOrder> {
    private final FoodDataToFood foodDataToFood;

    public FoodOrderDataToFoodOrder(FoodDataToFood foodDataToFood) {
        this.foodDataToFood = foodDataToFood;
    }

    @Override
    public FoodOrder convert(FoodOrderData foodOrderData) {
        return FoodOrder.FoodOrderBuilder.aFoodOrder()
                .id(foodOrderData.getId())
                .date(foodOrderData.getDate())
                .discount(foodOrderData.getDiscount())
                .food(foodDataToFood.convert(foodOrderData.getFood()))
                .createdAt(foodOrderData.getCreatedAt())
                .modifiedAt(foodOrderData.getModifiedAt())
                .createdBy(foodOrderData.getCreatedBy())
                .modifiedBy(foodOrderData.getModifiedBy())
                .build();
    }
}
