package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.TravelerDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.tour.Traveler;

import java.time.ZoneId;

public class TravelerToTravelerDto implements Mapper<Traveler, TravelerDto> {
    private final AddressToAddressDto addressToAddressDto;

    public TravelerToTravelerDto(AddressToAddressDto addressToAddressDto) {
        this.addressToAddressDto = addressToAddressDto;
    }

    @Override
    public TravelerDto convert(Traveler traveler) {
        return TravelerDto.TravelerDtoBuilder.aTravelerDto()
                .id(traveler.getId())
                .name(traveler.getName())
                .email(traveler.getEmail())
                .nationalId(traveler.getNationalId())
                .phone(traveler.getPhone())
                .address(traveler.getAddress() != null ? addressToAddressDto.convert(traveler.getAddress()) : null)
                .createdAt(traveler.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(traveler.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(traveler.getCreatedBy())
                .modifiedBy(traveler.getModifiedBy())
                .build();
    }
}
