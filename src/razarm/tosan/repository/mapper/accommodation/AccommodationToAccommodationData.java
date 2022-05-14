package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.AccommodationData;
import razarm.tosan.repository.domain.accommodation.Accommodation;

public class AccommodationToAccommodationData implements Mapper<Accommodation, AccommodationData> {
    @Override
    public AccommodationData convert(Accommodation accommodation) {
        final Mapper<Accommodation, AccommodationData> mapper = AccommodationDataMapperFactory.createAccommodationMapper(accommodation.getType());
        return mapper.convert(accommodation);
    }
}