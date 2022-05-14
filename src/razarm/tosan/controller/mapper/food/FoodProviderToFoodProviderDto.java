package razarm.tosan.controller.mapper.food;

import razarm.tosan.controller.dto.food.FoodProviderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.food.FoodProvider;

import java.time.ZoneId;

public class FoodProviderToFoodProviderDto implements Mapper<FoodProvider, FoodProviderDto> {

    @Override
    public FoodProviderDto convert(FoodProvider foodProvider) {
        return FoodProviderDto.FoodProviderDtoBuilder.aFoodProviderDto()
                                                     .id(foodProvider.getId())
                                                     .name(foodProvider.getName())
                                                     .address(foodProvider.getAddress())
                                                     .phone(foodProvider.getPhone())
                                                     .email(foodProvider.getEmail())
                                                     .description(foodProvider.getDescription())
//                                                     .foods(foodProvider.getFoods().stream().map(foodToFoodDto::convert).collect(Collectors.toUnmodifiableSet()))
                                                     .createdAt(foodProvider.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                                     .modifiedAt(foodProvider.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                                     .createdBy(foodProvider.getCreatedBy())
                                                     .modifiedBy(foodProvider.getModifiedBy())
                                                     .build();
    }
}
