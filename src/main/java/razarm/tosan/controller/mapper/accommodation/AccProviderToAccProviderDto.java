package razarm.tosan.controller.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.accommodation.AccommodationProviderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.accommodation.AccommodationProvider;

import java.time.ZoneId;
@Component
public class AccProviderToAccProviderDto implements Mapper<AccommodationProvider, AccommodationProviderDto> {
    private final AddressToAddressDto addressToAddressDto;

    public AccProviderToAccProviderDto(AddressToAddressDto addressToAddressDto) {
        this.addressToAddressDto = addressToAddressDto;
    }

    @Override
    public AccommodationProviderDto convert(AccommodationProvider accommodationProvider) {
        return AccommodationProviderDto.AccommodationProviderDtoBuilder.anAccommodationProviderDto()
            .id(accommodationProvider.getId())
            .name(accommodationProvider.getName())
            .description(accommodationProvider.getDescription())
            .email(accommodationProvider.getEmail())
            .phone(accommodationProvider.getPhone())
            .address(accommodationProvider.getAddress() != null ? addressToAddressDto.convert(accommodationProvider.getAddress()) : null)
            .createdAt(
                accommodationProvider.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(
                accommodationProvider.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(accommodationProvider.getCreatedBy())
            .modifiedBy(accommodationProvider.getModifiedBy())
            .build();
    }
}
