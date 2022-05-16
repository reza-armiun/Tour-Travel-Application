package razarm.tosan.controller.mapper.accommodation;

import razarm.tosan.controller.dto.accommodation.AccommodationDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.accommodation.Accommodation;

public class AccommodationToAccommodationDto implements Mapper<Accommodation, AccommodationDto> {
    @Override
    public AccommodationDto convert(Accommodation accommodation) {
        final Mapper<Accommodation, AccommodationDto> mapper = AccommodationDtoMapperFactory.createAccommodationMapper(accommodation.getType());
        return mapper.convert(accommodation);
    }
}
