package razarm.tosan.repository.mapper.food;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.food.FoodData;
import razarm.tosan.repository.domain.food.Food;

@Component
public class FoodDataToFood implements Mapper<FoodData, Food> {
    private final FoodProviderDataToFoodProvider foodDataProviderToFoodProvider;

    public FoodDataToFood(FoodProviderDataToFoodProvider foodDataProviderToFoodProvider) {
        this.foodDataProviderToFoodProvider = foodDataProviderToFoodProvider;
    }

    @Override
    public Food convert(FoodData foodData) {
        return Food.FoodBuilder.aFood()
                .id(foodData.getId())
                .name(foodData.getName())
                .type(foodData.getType())
                .ingredients(foodData.getIngredients())
                .price(foodData.getPrice())
                .cookTime(foodData.getCookTime())
                .provider(foodDataProviderToFoodProvider.convert(foodData.getProvider()))
                .createdAt(foodData.getCreatedAt())
                .modifiedAt(foodData.getModifiedAt())
                .createdBy(foodData.getCreatedBy())
                .modifiedBy(foodData.getModifiedBy())
                .build();
    }
}
