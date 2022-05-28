package razarm.tosan.repository.mapper;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TravelerData;
import razarm.tosan.repository.domain.tour.Traveler;
import razarm.tosan.repository.mapper.location.AddressToAddressData;

@Component
public class TravelerToTravelerData implements Mapper<Traveler, TravelerData> {
    private final AddressToAddressData addressToAddressData;

    public TravelerToTravelerData(AddressToAddressData addressToAddressData) {
        this.addressToAddressData = addressToAddressData;
    }

    @Override
    public TravelerData convert(Traveler traveler) {
    return TravelerData.TravelerDataBuilder.aTravelerData()
            .id(traveler.getId())
            .name(traveler.getName())
            .email(traveler.getEmail())
            .address(traveler.getAddress() != null ?addressToAddressData.convert(traveler.getAddress()): null)
            .nationalId(traveler.getNationalId())
            .phone(traveler.getPhone())
            .createdAt(traveler.getCreatedAt())
            .modifiedAt(traveler.getModifiedAt())
            .createdBy(traveler.getCreatedBy())
            .modifiedBy(traveler.getModifiedBy())
            .build();
    }
}
