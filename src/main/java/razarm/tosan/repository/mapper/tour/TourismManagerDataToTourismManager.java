package razarm.tosan.repository.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TourismManagerData;
import razarm.tosan.repository.domain.tour.TourismManager;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;

@Component
public class TourismManagerDataToTourismManager implements Mapper<TourismManagerData, TourismManager> {
    private final AddressDataToAddress addressDataToAddress;

    public TourismManagerDataToTourismManager(AddressDataToAddress addressDataToAddress) {
        this.addressDataToAddress = addressDataToAddress;
    }

    @Override
    public TourismManager convert(TourismManagerData tourismManagerData) {
    return TourismManager.TourismManagerBuilder.aTourismManager()
            .id(tourismManagerData.getId())
            .name(tourismManagerData.getName())
            .email(tourismManagerData.getEmail())
            .phone(tourismManagerData.getPhone())
            .address(tourismManagerData.getAddress() != null ? addressDataToAddress.convert(tourismManagerData.getAddress()): null)
            .nationalId(tourismManagerData.getNationalId())
            .createdAt(tourismManagerData.getCreatedAt())
            .modifiedAt(tourismManagerData.getModifiedAt())
            .createdBy(tourismManagerData.getCreatedBy())
            .modifiedBy(tourismManagerData.getModifiedBy())
            .build();
    }
}
