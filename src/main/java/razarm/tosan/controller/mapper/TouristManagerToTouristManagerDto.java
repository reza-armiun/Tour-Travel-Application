package razarm.tosan.controller.mapper;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.repository.domain.tour.TourismManager;
import razarm.tosan.controller.dto.tour.TourismManagerDto;
@Component
public class TouristManagerToTouristManagerDto implements Mapper <TourismManager, TourismManagerDto> {
    private final AddressToAddressDto mapper ;

    public TouristManagerToTouristManagerDto(AddressToAddressDto mapper) {
        this.mapper = mapper;
    }

    @Override
    public TourismManagerDto convert(TourismManager tourismManager) {
        return TourismManagerDto.TourismManagerDtoBuilder.aTourismManagerDto()
                .id(tourismManager.getId())
                .name(tourismManager.getName())
                .email(tourismManager.getEmail())
                .phone(tourismManager.getPhone())
                .nationalId(tourismManager.getNationalId())
                .address(this.mapper.convert(tourismManager.getAddress()))
                .build();
    }
}
