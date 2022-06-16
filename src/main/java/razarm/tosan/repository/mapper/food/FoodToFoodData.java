package razarm.tosan.repository.mapper.food;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.food.FoodData;
import razarm.tosan.repository.domain.food.Food;

@Component
public class FoodToFoodData implements Mapper<Food, FoodData> {
    private final FoodProviderToFoodProviderData foodProviderToFoodProviderData;

    public FoodToFoodData(FoodProviderToFoodProviderData foodProviderToFoodProviderData) {
        this.foodProviderToFoodProviderData = foodProviderToFoodProviderData;
    }

    @Override
    public FoodData convert(Food food) {
        return FoodData.FoodDataBuilder.aFoodData()
                .id(food.getId())
                .name(food.getName())
                .ingredients(food.getIngredients())
                .price(food.getPrice())
                .cookTime(food.getCookTime())
                .provider(food.getProvider() != null ? foodProviderToFoodProviderData.convert(food.getProvider()): null)
                .createdAt(food.getCreatedAt())
                .modifiedAt(food.getModifiedAt())
                .createdBy(food.getCreatedBy())
                .modifiedBy(food.getModifiedBy())
                .build();
    }
}
