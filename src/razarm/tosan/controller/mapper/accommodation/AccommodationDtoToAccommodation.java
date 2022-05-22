package razarm.tosan.controller.mapper.accommodation;

import razarm.tosan.controller.dto.accommodation.AccommodationDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.accommodation.Accommodation;

public class AccommodationDtoToAccommodation<S extends AccommodationDto, T extends Accommodation> implements Mapper<S, T> {
    @Override
    public T convert(S accommodationDto) {
        final Mapper<S, T> mapper = AccommodationDtoMapperFactory.createAccommodationDtoMapper(accommodationDto.getType());

        return mapper.convert(accommodationDto);
    }
}
