package razarm.tosan.repository.inMemoryImpl.food;

import razarm.tosan.repository.FoodOrderRepository;
import razarm.tosan.repository.data.food.FoodData;
import razarm.tosan.repository.data.food.FoodOrderData;
import razarm.tosan.repository.domain.food.FoodOrder;
import razarm.tosan.repository.mapper.food.FoodOrderDataToFoodOrder;
import razarm.tosan.repository.mapper.food.FoodOrderToFoodOrderData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodOrderRepositoryImpl implements FoodOrderRepository {
    private Map<String, FoodOrderData> foodDataMap = new HashMap<>();

    private final FoodOrderDataToFoodOrder foodOrderDataToFoodOrder;
    private final FoodOrderToFoodOrderData foodOrderToFoodOrderData;

    public FoodOrderRepositoryImpl(FoodOrderDataToFoodOrder foodOrderDataToFoodOrder, FoodOrderToFoodOrderData foodOrderToFoodOrderData) {
        this.foodOrderDataToFoodOrder = foodOrderDataToFoodOrder;
        this.foodOrderToFoodOrderData = foodOrderToFoodOrderData;
    }

    @Override
    public FoodOrder save(FoodOrder foodOrder) {
        final var orderData = foodOrderToFoodOrderData.convert(foodOrder);
        foodDataMap.put(orderData.getId(), orderData);
        return foodOrder.cloneWithId(orderData.getId());
    }

    @Override
    public void update(FoodOrder foodOrder) {
        final var orderData = foodOrderToFoodOrderData.convert(foodOrder);
        foodDataMap.put(orderData.getId(), orderData);
    }

    @Override
    public void deleteById(String s) {
            foodDataMap.remove(s);
    }

    @Override
    public FoodOrder findById(String s) {
        return foodOrderDataToFoodOrder.convert(foodDataMap.get(s));
    }

    @Override
    public List<FoodOrder> findAll() {
        return foodDataMap.values().stream().map(foodOrderDataToFoodOrder::convert).collect(Collectors.toUnmodifiableList());
    }
}
