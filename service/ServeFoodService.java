package razarm.tosan.service;

import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.dto.food.FoodProviderDto;

import java.util.List;

public interface ServeFoodService extends CrudService<FoodProviderDto, String> {

    List<FoodDto> findAllAvailableFoods();
    List<FoodDto> findFoodsByName(String name);
//    List<FoodDto> findFoodsByType(FoodType type);
    List<FoodProviderDto> findAllFoodProviders();

    FoodProviderDto findByName(String name);

    FoodDto addFood(String providerId, FoodDto foodDto);
    void updateFood(String providerId, FoodDto foodDto);
    void removeFood(String providerId, String foodId);
    List<FoodDto> findProviderFoodList(String providerId);




}
