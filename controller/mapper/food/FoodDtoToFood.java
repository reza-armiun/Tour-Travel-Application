package razarm.tosan.controller.mapper.food;

import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.food.Food;

public class FoodDtoToFood implements Mapper<FoodDto, Food> {
    @Override
    public Food convert(FoodDto foodDto) {
        return Food.FoodBuilder.aFood()
                               .id(foodDto.getId())
                               .name(foodDto.getName())
                               .type(foodDto.getType())
                               .ingredients(foodDto.getIngredients())
                               .price(foodDto.getPrice())
                               .cookTime(foodDto.getCookTime())
                               .cookTime(foodDto.getCookTime())
                               .createdAt(foodDto.getCreatedAt().toInstant())
                               .modifiedAt(foodDto.getModifiedAt().toInstant())
                               .createdBy(foodDto.getCreatedBy())
                               .modifiedBy(foodDto.getModifiedBy())
                               .build();
    }
}
