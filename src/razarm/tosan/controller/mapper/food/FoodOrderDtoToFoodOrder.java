package razarm.tosan.controller.mapper.food;

import razarm.tosan.controller.dto.food.FoodOrderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.food.FoodOrder;

public class FoodOrderDtoToFoodOrder implements Mapper<FoodOrderDto, FoodOrder> {
    private final FoodDtoToFood foodDtoToFood;

    public FoodOrderDtoToFoodOrder(FoodDtoToFood foodDtoToFood) {
        this.foodDtoToFood = foodDtoToFood;
    }

    @Override
    public FoodOrder convert(FoodOrderDto foodOrderDto) {
        return FoodOrder.FoodOrderBuilder.aFoodOrder()
                .id(foodOrderDto.getId())
                .date(foodOrderDto.getDate().toInstant())
                .discount(foodOrderDto.getDiscount())
                .food(foodDtoToFood.convert(foodOrderDto.getFood()))
                .createdAt(foodOrderDto.getCreatedAt().toInstant())
                .modifiedAt(foodOrderDto.getModifiedAt().toInstant())
                .createdBy(foodOrderDto.getCreatedBy())
                .modifiedBy(foodOrderDto.getModifiedBy())
                .build();
    }
}
