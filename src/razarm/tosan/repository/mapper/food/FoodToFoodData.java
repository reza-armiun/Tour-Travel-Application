package razarm.tosan.repository.mapper.food;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.food.FoodData;
import razarm.tosan.repository.domain.food.Food;

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
                .provider(foodProviderToFoodProviderData.convert(food.getProvider()))
                .createdAt(food.getCreatedAt())
                .modifiedAt(food.getModifiedAt())
                .createdBy(food.getCreatedBy())
                .modifiedBy(food.getModifiedBy())
                .build();
    }
}
