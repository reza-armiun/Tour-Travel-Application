package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.AccommodationOrderData;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;

public class AccOrderDataToAccOrder implements Mapper<AccommodationOrderData, AccommodationOrder> {
    private final AccommodationDataToAccommodation accommodationDataToAccommodation;

    public AccOrderDataToAccOrder(AccommodationDataToAccommodation accommodationDataToAccommodation) {
        this.accommodationDataToAccommodation = accommodationDataToAccommodation;
    }

    @Override
    public AccommodationOrder convert(AccommodationOrderData accommodationOrderData) {
        return AccommodationOrder.AccommodationOrderBuilder.anAccommodationOrder()
                .id(accommodationOrderData.getId())
                .date(accommodationOrderData.getDate())
                .discount(accommodationOrderData.getDiscount())
                .accommodation(accommodationDataToAccommodation.convert(accommodationOrderData.getAccommodation()))
                .createdAt(accommodationOrderData.getCreatedAt())
                .modifiedAt(accommodationOrderData.getModifiedAt())
                .createdBy(accommodationOrderData.getCreatedBy())
                .modifiedBy(accommodationOrderData.getModifiedBy())
                .build();
    }
}
