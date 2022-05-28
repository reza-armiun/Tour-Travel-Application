package razarm.tosan.controller.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.accommodation.AccommodationOrderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;

import java.time.ZoneId;
@Component
public class AccOrderToAccOrderDto implements Mapper<AccommodationOrder, AccommodationOrderDto> {
    private final AccommodationToAccommodationDto accommodationToAccommodationDto ;

    public AccOrderToAccOrderDto(AccommodationToAccommodationDto accommodationToAccommodationDto) {
        this.accommodationToAccommodationDto = accommodationToAccommodationDto;
    }

    @Override
    public AccommodationOrderDto convert(AccommodationOrder accommodationOrder) {
        return AccommodationOrderDto.AccommodationOrderDtoBuilder.anAccommodationOrderDto()
                .id(accommodationOrder.getId())
                .date(accommodationOrder.getDate().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .discount(accommodationOrder.getDiscount())
                .accommodation(accommodationToAccommodationDto.convert(accommodationOrder.getAccommodation()))
                .createdAt(accommodationOrder.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(accommodationOrder.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(accommodationOrder.getCreatedBy())
                .modifiedBy(accommodationOrder.getModifiedBy())
                .build();
    }
}
