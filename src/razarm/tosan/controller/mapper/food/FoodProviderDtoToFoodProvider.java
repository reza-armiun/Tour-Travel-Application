package razarm.tosan.controller.mapper.food;

import razarm.tosan.controller.dto.food.FoodProviderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.food.FoodProvider;

public class FoodProviderDtoToFoodProvider implements Mapper<FoodProviderDto, FoodProvider> {

    @Override
    public FoodProvider convert(FoodProviderDto foodProviderDto) {
        return FoodProvider.FoodProviderBuilder.aFoodProvider()
                                               .id(foodProviderDto.getId())
                                               .name(foodProviderDto.getName())
                                               .address(foodProviderDto.getAddress())
                                               .phone(foodProviderDto.getPhone())
                                               .email(foodProviderDto.getEmail())
                                               .description(foodProviderDto.getDescription())
//                                               .foods(foodProviderDto.getFoods().stream().map(foodDtoToFood::convert).collect(Collectors.toUnmodifiableSet()))
                                               .createdAt(foodProviderDto.getCreatedAt().toInstant())
                                               .modifiedAt(foodProviderDto.getModifiedAt().toInstant())
                                               .createdBy(foodProviderDto.getCreatedBy())
                                               .modifiedBy(foodProviderDto.getModifiedBy())
                                               .build();
    }
}
