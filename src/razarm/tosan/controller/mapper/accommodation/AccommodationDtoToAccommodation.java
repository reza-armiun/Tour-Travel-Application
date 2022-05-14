package razarm.tosan.controller.mapper.accommodation;

import razarm.tosan.controller.dto.accommodation.AccommodationDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.accommodation.Accommodation;

public class AccommodationDtoToAccommodation implements Mapper<AccommodationDto, Accommodation> {
    @Override
    public Accommodation convert(AccommodationDto accommodationDto) {
        final Mapper<AccommodationDto, Accommodation> mapper = AccommodationDtoMapperFactory.createAccommodationDtoMapper(accommodationDto.getType());
        return mapper.convert(accommodationDto);
    }
}
