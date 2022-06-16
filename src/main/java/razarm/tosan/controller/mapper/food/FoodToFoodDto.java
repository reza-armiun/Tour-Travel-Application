package razarm.tosan.controller.mapper.food;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.food.Food;

import java.time.ZoneId;
@Component
public class FoodToFoodDto implements Mapper<Food, FoodDto> {
    private final FoodProviderToFoodProviderDto foodProviderToFoodProviderDto;

    public FoodToFoodDto(FoodProviderToFoodProviderDto foodProviderToFoodProviderDto) {
        this.foodProviderToFoodProviderDto = foodProviderToFoodProviderDto;
    }

    @Override
    public FoodDto convert(Food food) {
        return FoodDto.FoodDtoBuilder.aFoodDto()
            .id(food.getId())
            .name(food.getName())
            .type(food.getType())
            .ingredients(food.getIngredients())
            .price(food.getPrice())
            .cookTime(food.getCookTime())
            .provider(food.getProvider() != null ? foodProviderToFoodProviderDto.convert(food.getProvider()) : null)
            .createdAt(food.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(food.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(food.getCreatedBy())
            .modifiedBy(food.getModifiedBy())
            .build();
    }
}
