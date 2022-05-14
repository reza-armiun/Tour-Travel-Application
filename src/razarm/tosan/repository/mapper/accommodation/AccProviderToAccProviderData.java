package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.AccommodationProviderData;
import razarm.tosan.repository.domain.accommodation.AccommodationProvider;

public class AccProviderToAccProviderData implements Mapper<AccommodationProvider, AccommodationProviderData> {
    @Override
    public AccommodationProviderData convert(AccommodationProvider accommodationProvider) {
    return AccommodationProviderData.AccommodationProviderDataBuilder.anAccommodationProviderData()
            .id(accommodationProvider.getId())
            .name(accommodationProvider.getName())
            .description(accommodationProvider.getDescription())
            .email(accommodationProvider.getEmail())
            .phone(accommodationProvider.getPhone())
            .addressId(accommodationProvider.getAddress() != null ? accommodationProvider.getAddress().getId() : null)
        .build();
    }
}
