package razarm.tosan.controller.mapper.accommodation;

import razarm.tosan.controller.dto.accommodation.AccommodationProviderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.repository.domain.accommodation.AccommodationProvider;

public class AccProviderDtoToAccProvider implements Mapper<AccommodationProviderDto, AccommodationProvider> {
    private final AddressDtoToAddress addressDtoToAddress;

    public AccProviderDtoToAccProvider(AddressDtoToAddress addressDtoToAddress) {
        this.addressDtoToAddress = addressDtoToAddress;
    }

    @Override
    public AccommodationProvider convert(AccommodationProviderDto accommodationProviderDto) {
    return AccommodationProvider.AccommodationProviderBuilder.anAccommodationProvider()
            .id(accommodationProviderDto.getId())
            .name(accommodationProviderDto.getName())
            .description(accommodationProviderDto.getDescription())
            .email(accommodationProviderDto.getEmail())
            .phone(accommodationProviderDto.getPhone())
            .address(accommodationProviderDto.getAddress() != null ? addressDtoToAddress.convert(accommodationProviderDto.getAddress()) : null)
            .createdAt(accommodationProviderDto.getCreatedAt().toInstant())
            .modifiedAt(accommodationProviderDto.getModifiedAt().toInstant())
            .createdBy(accommodationProviderDto.getCreatedBy())
            .modifiedBy(accommodationProviderDto.getModifiedBy())
            .build();
    }
}
