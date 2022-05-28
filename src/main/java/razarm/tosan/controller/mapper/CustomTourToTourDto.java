package razarm.tosan.controller.mapper;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.repository.domain.tour.CustomTour;
import razarm.tosan.props.AppProperties;

import java.time.ZoneId;


@Component
public class CustomTourToTourDto implements Mapper<CustomTour, TourDto>{
    private final TouristManagerToTouristManagerDto mapper;

    public CustomTourToTourDto(TouristManagerToTouristManagerDto mapper) {
        this.mapper = mapper;
    }

    @Override
    public TourDto convert(CustomTour customTour) {
        return TourDto.TourDtoBuilder.aTourDto()
                .id(customTour.getId())
                .name(customTour.getName())
                .guide(customTour.getGuide())
                .description(customTour.getDescription())
                .date(customTour.getDate().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .tourismManager(this.mapper.convert(customTour.getTourismManager()))
                .build();
    }
}
