package razarm.tosan.controller.mapper.food;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.food.Food;
@Component
public class FoodDtoToFood implements Mapper<FoodDto, Food> {
    private final FoodProviderDtoToFoodProvider foodProviderDtoToFoodProvider;

    public FoodDtoToFood(FoodProviderDtoToFoodProvider foodProviderDtoToFoodProvider) {
        this.foodProviderDtoToFoodProvider = foodProviderDtoToFoodProvider;
    }

    @Override
    public Food convert(FoodDto foodDto) {
        return Food.FoodBuilder.aFood()
                               .id(foodDto.getId())
                               .name(foodDto.getName())
                               .type(foodDto.getType())
                               .ingredients(foodDto.getIngredients())
                               .price(foodDto.getPrice())
                               .cookTime(foodDto.getCookTime())
                               .provider(foodProviderDtoToFoodProvider.convert(foodDto.getProvider()))
                               .createdAt(foodDto.getCreatedAt().toInstant())
                               .modifiedAt(foodDto.getModifiedAt().toInstant())
                               .createdBy(foodDto.getCreatedBy())
                               .modifiedBy(foodDto.getModifiedBy())
                               .build();
    }
}
