package razarm.tosan.controller.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.TourismManagerDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.repository.domain.tour.TourismManager;
@Component
public class TourismManagerDtoToTourismManager implements Mapper<TourismManagerDto, TourismManager> {
    private final AddressDtoToAddress addressDtoToAddress;

    public TourismManagerDtoToTourismManager(AddressDtoToAddress addressDtoToAddress) {
        this.addressDtoToAddress = addressDtoToAddress;
    }

    @Override
    public TourismManager convert(TourismManagerDto tourismManagerDto) {
        return TourismManager.TourismManagerBuilder.aTourismManager()
                .id(tourismManagerDto.getId())
                .name(tourismManagerDto.getName())
                .email(tourismManagerDto.getEmail())
                .phone(tourismManagerDto.getPhone())
                .address(tourismManagerDto.getAddress() != null ? addressDtoToAddress.convert(tourismManagerDto.getAddress()): null)
                .nationalId(tourismManagerDto.getNationalId())
                .createdAt(tourismManagerDto.getCreatedAt().toInstant())
                .modifiedAt(tourismManagerDto.getModifiedAt().toInstant())
                .createdBy(tourismManagerDto.getCreatedBy())
                .modifiedBy(tourismManagerDto.getModifiedBy())
                .build();
    }
}
