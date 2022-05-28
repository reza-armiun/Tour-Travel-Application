package razarm.tosan.controller.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.TourismManagerDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.tour.TourismManager;

import java.time.ZoneId;
@Component
public class TourismManagerToTourismManagerDto implements Mapper<TourismManager, TourismManagerDto> {
    private final AddressToAddressDto addressToAddressDto;

    public TourismManagerToTourismManagerDto(AddressToAddressDto addressToAddressDto) {
        this.addressToAddressDto = addressToAddressDto;
    }

    @Override
    public TourismManagerDto convert(TourismManager tourismManager) {
    return TourismManagerDto.TourismManagerDtoBuilder.aTourismManagerDto()
            .id(tourismManager.getId())
            .name(tourismManager.getName())
            .email(tourismManager.getEmail())
            .phone(tourismManager.getPhone())
            .address(tourismManager.getAddress() != null? addressToAddressDto.convert(tourismManager.getAddress()): null)
            .nationalId(tourismManager.getNationalId())
            .createdAt(tourismManager.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(tourismManager.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(tourismManager.getCreatedBy())
            .modifiedBy(tourismManager.getModifiedBy())
            .build();
    }
}
