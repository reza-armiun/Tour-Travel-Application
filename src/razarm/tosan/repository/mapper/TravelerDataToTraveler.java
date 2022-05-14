package razarm.tosan.repository.mapper;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TravelerData;
import razarm.tosan.repository.domain.tour.Traveler;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;

public class TravelerDataToTraveler implements Mapper<TravelerData, Traveler> {
    private final AddressDataToAddress addressDataToAddress;

    public TravelerDataToTraveler(AddressDataToAddress addressDataToAddress) {
        this.addressDataToAddress = addressDataToAddress;
    }

    @Override
    public Traveler convert(TravelerData travelerData) {
    return Traveler.TravelerBuilder.aTraveler()
            .id(travelerData.getId())
            .name(travelerData.getName())
            .email(travelerData.getEmail())
            .nationalId(travelerData.getNationalId())
            .phone(travelerData.getPhone())
            .address(travelerData.getAddress() != null ? addressDataToAddress.convert(travelerData.getAddress()): null)
            .createdAt(travelerData.getCreatedAt())
            .modifiedAt(travelerData.getModifiedAt())
            .createdBy(travelerData.getCreatedBy())
            .modifiedBy(travelerData.getModifiedBy())
            .build();
    }
}
