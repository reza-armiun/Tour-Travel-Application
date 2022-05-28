package razarm.tosan.repository.mapper.food;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.food.FoodProviderData;
import razarm.tosan.repository.domain.food.FoodProvider;

@Component
public class FoodProviderToFoodProviderData implements Mapper<FoodProvider, FoodProviderData> {
    @Override
    public FoodProviderData convert(FoodProvider foodProvider) {
        return FoodProviderData.FoodProviderDataBuilder.aFoodProviderData()
                .id(foodProvider.getId())
                .name(foodProvider.getName())
                .address(foodProvider.getAddress())
                .phone(foodProvider.getPhone())
                .email(foodProvider.getEmail())
                .description(foodProvider.getDescription())
                .createdAt(foodProvider.getCreatedAt())
                .modifiedAt(foodProvider.getModifiedAt())
                .createdBy(foodProvider.getCreatedBy())
                .modifiedBy(foodProvider.getModifiedBy())
                .build();
    }
}
