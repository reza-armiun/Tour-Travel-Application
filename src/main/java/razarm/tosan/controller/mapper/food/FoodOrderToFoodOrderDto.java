package razarm.tosan.controller.mapper.food;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.food.FoodOrderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.food.FoodOrder;

import java.time.ZoneId;
@Component
public class FoodOrderToFoodOrderDto implements Mapper<FoodOrder, FoodOrderDto> {
    private final FoodToFoodDto foodToFoodDto;

    public FoodOrderToFoodOrderDto(FoodToFoodDto foodToFoodDto) {
        this.foodToFoodDto = foodToFoodDto;
    }

    @Override
    public FoodOrderDto convert(FoodOrder foodOrder) {
        return FoodOrderDto.FoodOrderDtoBuilder.aFoodOrderDto()
                .id(foodOrder.getId())
                .date(foodOrder.getDate().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .discount(foodOrder.getDiscount())
                .food(foodToFoodDto.convert(foodOrder.getFood()))
                .createdAt(foodOrder.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(foodOrder.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(foodOrder.getCreatedBy())
                .modifiedBy(foodOrder.getModifiedBy())
                .build();
    }
}
