package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.tour.Tour;

import java.time.ZoneId;
import java.util.stream.Collectors;

public class TourToTourDto implements Mapper<Tour, TourDto> {
    private final TourismManagerToTourismManagerDto tourismManagerToTourismManagerDto;
    private final SchedulePlanToSchedulePlanDto schedulePlanToSchedulePlanDto;

    public TourToTourDto(TourismManagerToTourismManagerDto tourismManagerToTourismManagerDto, SchedulePlanToSchedulePlanDto schedulePlanToSchedulePlanDto) {
        this.tourismManagerToTourismManagerDto = tourismManagerToTourismManagerDto;
        this.schedulePlanToSchedulePlanDto = schedulePlanToSchedulePlanDto;
    }

    @Override
    public TourDto convert(Tour tour) {
        return TourDto.TourDtoBuilder.aTourDto()
                .id(tour.getId())
                .name(tour.getName())
                .type(tour.getType())
                .guide(tour.getGuide())
                .description(tour.getDescription())
                .date(tour.getDate().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .categories(tour.getCategories())
                .tourismManager(tourismManagerToTourismManagerDto.convert(tour.getTourismManager()))
                .schedulePlans(tour.getSchedulePlans().stream().map(schedulePlanToSchedulePlanDto::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(tour.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(tour.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(tour.getCreatedBy())
                .modifiedBy(tour.getModifiedBy())
                .build();
    }
}
