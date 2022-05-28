package razarm.tosan.repository.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TourismManagerData;
import razarm.tosan.repository.domain.tour.TourismManager;
import razarm.tosan.repository.mapper.location.AddressToAddressData;

@Component
public class TourismManagerToTourismManagerData implements Mapper<TourismManager, TourismManagerData> {
    private final AddressToAddressData addressToAddressData;

    public TourismManagerToTourismManagerData(AddressToAddressData addressToAddressData) {
        this.addressToAddressData = addressToAddressData;
    }

    @Override
    public TourismManagerData convert(TourismManager tourismManager) {
    return TourismManagerData.TourismManagerDataBuilder.aTourismManagerData()
            .id(tourismManager.getId())
            .name(tourismManager.getName())
            .email(tourismManager.getEmail())
            .phone(tourismManager.getPhone())
            .address(tourismManager.getAddress() != null ? addressToAddressData.convert(tourismManager.getAddress()) : null)
            .nationalId(tourismManager.getNationalId())
            .createdAt(tourismManager.getCreatedAt())
            .modifiedAt(tourismManager.getModifiedAt())
            .createdBy(tourismManager.getCreatedBy())
            .modifiedBy(tourismManager.getModifiedBy())
            .build();
    }
}
