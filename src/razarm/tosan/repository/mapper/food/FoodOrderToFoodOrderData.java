package razarm.tosan.repository.mapper.food;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.food.FoodOrderData;
import razarm.tosan.repository.domain.food.FoodOrder;

public class FoodOrderToFoodOrderData  implements Mapper<FoodOrder, FoodOrderData> {
    private final FoodToFoodData foodToFoodData;

    public FoodOrderToFoodOrderData(FoodToFoodData foodToFoodData) {
        this.foodToFoodData = foodToFoodData;
    }

    @Override
    public FoodOrderData convert(FoodOrder foodOrder) {
        return FoodOrderData.FoodOrderDataBuilder.aFoodOrderData()
                .id(foodOrder.getId())
                .date(foodOrder.getDate())
                .discount(foodOrder.getDiscount())
                .food(foodToFoodData.convert(foodOrder.getFood()))
                .createdAt(foodOrder.getCreatedAt())
                .modifiedAt(foodOrder.getModifiedAt())
                .createdBy(foodOrder.getCreatedBy())
                .modifiedBy(foodOrder.getModifiedBy())
                .build();
    }
}
