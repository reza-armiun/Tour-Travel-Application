package razarm.tosan.repository.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.AccommodationData;
import razarm.tosan.repository.domain.accommodation.Accommodation;
@Component
public class AccommodationDataToAccommodation implements Mapper<AccommodationData, Accommodation> {
    @Override
    public Accommodation convert(AccommodationData accommodationData) {
        final Mapper<AccommodationData, Accommodation> mapper = AccommodationDataMapperFactory.createAccommodationDataMapper(accommodationData.getType());
        return mapper.convert(accommodationData);
    }
}
