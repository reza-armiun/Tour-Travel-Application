package razarm.tosan.controller.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.accommodation.AccommodationOrderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;
@Component
public class AccOrderDtoToAccOrder implements Mapper<AccommodationOrderDto, AccommodationOrder> {
    private final AccommodationDtoToAccommodation accommodationDtoToAccommodation;

    public AccOrderDtoToAccOrder(AccommodationDtoToAccommodation accommodationDtoToAccommodation) {
        this.accommodationDtoToAccommodation = accommodationDtoToAccommodation;
    }

    @Override
    public AccommodationOrder convert(AccommodationOrderDto accommodationOrderDto) {
        return AccommodationOrder.AccommodationOrderBuilder.anAccommodationOrder()
                .id(accommodationOrderDto.getId())
                .date(accommodationOrderDto.getDate().toInstant())
                .discount(accommodationOrderDto.getDiscount())
                .accommodation(accommodationDtoToAccommodation.convert(accommodationOrderDto.getAccommodation()))
                .createdAt(accommodationOrderDto.getCreatedAt().toInstant())
                .modifiedAt(accommodationOrderDto.getModifiedAt().toInstant())
                .createdBy(accommodationOrderDto.getCreatedBy())
                .modifiedBy(accommodationOrderDto.getModifiedBy())
                .build();
    }
}
