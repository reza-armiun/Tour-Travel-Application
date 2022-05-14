package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.AccommodationProviderData;
import razarm.tosan.repository.domain.accommodation.AccommodationProvider;

public class AccProviderDataToAccProvider implements Mapper<AccommodationProviderData, AccommodationProvider> {
    @Override
    public AccommodationProvider convert(AccommodationProviderData accommodationProviderData) {
    return AccommodationProvider.AccommodationProviderBuilder.anAccommodationProvider()
            .id(accommodationProviderData.getId())
            .name(accommodationProviderData.getName())
            .description(accommodationProviderData.getDescription())
            .email(accommodationProviderData.getEmail())
            .phone(accommodationProviderData.getPhone())

            .createdAt(accommodationProviderData.getCreatedAt())
            .modifiedAt(accommodationProviderData.getModifiedAt())
            .createdBy(accommodationProviderData.getCreatedBy())
            .modifiedBy(accommodationProviderData.getModifiedBy())
            .build();
    }
}
