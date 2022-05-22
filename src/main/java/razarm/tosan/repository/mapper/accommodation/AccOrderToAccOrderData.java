package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.AccommodationOrderData;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;

public class AccOrderToAccOrderData implements Mapper<AccommodationOrder, AccommodationOrderData> {
    private final AccommodationToAccommodationData accommodationToAccommodationData;

    public AccOrderToAccOrderData(AccommodationToAccommodationData accommodationToAccommodationData) {
        this.accommodationToAccommodationData = accommodationToAccommodationData;
    }

    @Override
    public AccommodationOrderData convert(AccommodationOrder accommodationOrder) {
    return AccommodationOrderData.AccommodationOrderDataBuilder.anAccommodationOrderData()
            .id(accommodationOrder.getId())
            .date(accommodationOrder.getDate())
            .accommodation(accommodationToAccommodationData.convert(accommodationOrder.getAccommodation()))
            .discount(accommodationOrder.getDiscount())
            .createdAt(accommodationOrder.getCreatedAt())
            .modifiedAt(accommodationOrder.getModifiedAt())
            .createdBy(accommodationOrder.getCreatedBy())
            .modifiedBy(accommodationOrder.getModifiedBy())
            .build();
    }
}
