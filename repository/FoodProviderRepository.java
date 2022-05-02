package razarm.tosan.repository;

import razarm.tosan.repository.domain.food.Food;
import razarm.tosan.repository.domain.food.FoodProvider;


public interface FoodProviderRepository extends CrudRepository<FoodProvider, String> {

    FoodProvider findByName(String name);

    Food addFood(String providerId, Food food);
    void updateFood(String providerId, Food food);
    void removeFood(String providerId, String foodId);



}
