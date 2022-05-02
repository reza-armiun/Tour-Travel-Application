package razarm.tosan.repository.inMemoryImpl;

import razarm.tosan.repository.FoodProviderRepository;
import razarm.tosan.repository.domain.food.Food;
import razarm.tosan.repository.domain.food.FoodProvider;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoodProviderRepositoryImpl implements FoodProviderRepository {
    private Map<String ,FoodProvider> providerMapper = new HashMap<>();



    private void updateProviderFood(String providerId, Food food, FoodProvider foodProvider) {
        final var newFoodProvider =
                FoodProvider.FoodProviderBuilder.aFoodProvider()
                                                .id(providerId)
                                                .name(foodProvider.getName())
                                                .address(foodProvider.getAddress())
                                                .phone(foodProvider.getPhone())
                                                .email(foodProvider.getEmail())
                                                .description(foodProvider.getDescription())
                                                .foods(Stream.concat(foodProvider.getFoods().stream(), Stream.of(food)).collect(Collectors.toUnmodifiableSet()))
                                                .createdAt(foodProvider.getCreatedAt())
                                                .modifiedAt(foodProvider.getModifiedAt())
                                                .createdBy(foodProvider.getCreatedBy())
                                                .modifiedBy(foodProvider.getModifiedBy())
                                                .build();
        providerMapper.put(providerId, newFoodProvider);
    }


    @Override
    public FoodProvider save(FoodProvider foodProvider) {
        final var id = UUID.randomUUID().toString();
        final var newFoodProvider = FoodProvider.FoodProviderBuilder.aFoodProvider()
                                               .id(id)
                                               .name(foodProvider.getName())
                                               .address(foodProvider.getAddress())
                                               .phone(foodProvider.getPhone())
                                               .email(foodProvider.getEmail())
                                               .description(foodProvider.getDescription())
                                               .foods(foodProvider.getFoods())
                                               .createdAt(foodProvider.getCreatedAt())
                                               .modifiedAt(foodProvider.getModifiedAt())
                                               .createdBy(foodProvider.getCreatedBy())
                                               .modifiedBy(foodProvider.getModifiedBy())
                                               .build();
        providerMapper.put(id, newFoodProvider);
        return foodProvider;
    }

    @Override
    public void update(FoodProvider foodProvider) {
        providerMapper.put(foodProvider.getId(), foodProvider);
    }

    @Override
    public void deleteById(String s) {
        providerMapper.remove(s);
    }

    @Override
    public FoodProvider findById(String s) {
        return providerMapper.get(s);
    }

    @Override
    public List<FoodProvider> findAll() {
        return List.copyOf(providerMapper.values());
    }

    @Override
    public FoodProvider findByName(String name) {
        return providerMapper.values().stream()
                .filter(foodProvider -> foodProvider.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Food addFood(String providerId, Food food) {
        var foodProvider =providerMapper.get(providerId);
        final var id = UUID.randomUUID().toString();
        var newFood = Food.FoodBuilder.aFood()
                                      .id(id)
                                      .name(food.getName())
                                      .type(food.getType())
                                      .ingredients(food.getIngredients())
                                      .price(food.getPrice())
                                      .cookTime(food.getCookTime())
                                      .provider(foodProvider)
                                      .createdAt(foodProvider.getCreatedAt())
                                      .modifiedAt(foodProvider.getModifiedAt())
                                      .createdBy(foodProvider.getCreatedBy())
                                      .modifiedBy(foodProvider.getModifiedBy())
                                      .build();
        updateProviderFood(providerId, newFood, foodProvider);
        return newFood;

    }

    @Override
    public void updateFood(String providerId, Food food) {
        var foodProvider = providerMapper.get(providerId);
        updateProviderFood(providerId, food, foodProvider);
    }


    @Override
    public void removeFood(String providerId, String foodId) {
        var foodProvider =providerMapper.get(providerId);
        final var newFoodProvider =
                FoodProvider.FoodProviderBuilder.aFoodProvider()
                                                .id(providerId)
                                                .name(foodProvider.getName())
                                                .address(foodProvider.getAddress())
                                                .phone(foodProvider.getPhone())
                                                .email(foodProvider.getEmail())
                                                .description(foodProvider.getDescription())
                                                .foods(foodProvider.getFoods().stream().filter(food -> !food.getId().equals(foodId)).collect(Collectors.toUnmodifiableSet()))
                                                .createdAt(foodProvider.getCreatedAt())
                                                .modifiedAt(foodProvider.getModifiedAt())
                                                .createdBy(foodProvider.getCreatedBy())
                                                .modifiedBy(foodProvider.getModifiedBy())
                                                .build();
        providerMapper.put(providerId, newFoodProvider);
    }
}
