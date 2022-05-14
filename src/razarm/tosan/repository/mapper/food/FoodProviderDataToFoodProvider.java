package razarm.tosan.repository.mapper.food;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.food.FoodProviderData;
import razarm.tosan.repository.domain.food.FoodProvider;

public class FoodProviderDataToFoodProvider implements Mapper<FoodProviderData, FoodProvider> {
    @Override
    public FoodProvider convert(FoodProviderData foodProviderData) {
    return FoodProvider.FoodProviderBuilder.aFoodProvider()
        .id(foodProviderData.getId())
        .name(foodProviderData.getName())
        .address(foodProviderData.getAddress())
        .phone(foodProviderData.getPhone())
        .email(foodProviderData.getEmail())
        .description(foodProviderData.getDescription())
        .createdAt(foodProviderData.getCreatedAt())
        .modifiedAt(foodProviderData.getModifiedAt())
        .createdBy(foodProviderData.getCreatedBy())
        .modifiedBy(foodProviderData.getModifiedBy())
        .build();
    }
}
