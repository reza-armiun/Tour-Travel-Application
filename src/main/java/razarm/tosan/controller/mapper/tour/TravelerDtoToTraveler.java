package razarm.tosan.controller.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.TravelerDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.repository.domain.tour.Traveler;
@Component
public class TravelerDtoToTraveler implements Mapper<TravelerDto, Traveler> {
    private final AddressDtoToAddress addressDtoToAddress;

    public TravelerDtoToTraveler(AddressDtoToAddress addressDtoToAddress) {
        this.addressDtoToAddress = addressDtoToAddress;
    }

    @Override
    public Traveler convert(TravelerDto travelerDto) {
    return Traveler.TravelerBuilder.aTraveler()
            .id(travelerDto.getId())
            .name(travelerDto.getName())
            .email(travelerDto.getEmail())
            .nationalId(travelerDto.getNationalId())
            .phone(travelerDto.getPhone())
            .address(travelerDto.getAddress() != null ? addressDtoToAddress.convert(travelerDto.getAddress()): null)
            .createdAt(travelerDto.getCreatedAt().toInstant())
            .modifiedAt(travelerDto.getModifiedAt().toInstant())
            .createdBy(travelerDto.getCreatedBy())
            .modifiedBy(travelerDto.getModifiedBy())
            .build();
    }
}
