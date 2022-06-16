package razarm.tosan.controller.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.tour.Tour;

import java.time.ZoneId;
import java.util.stream.Collectors;
@Component
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
                .imgUrl(tour.getImgUrl())
                .date(
                        tour.getDate() != null
                                ? tour.getDate().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)).toOffsetDateTime()
                                : null)
                .tourismManager(
                        tour.getTourismManager() != null
                                ? tourismManagerToTourismManagerDto.convert(
                                        tour.getTourismManager())
                                : null)
                .schedulePlans(
                        tour.getSchedulePlans() != null
                                ? tour.getSchedulePlans().stream()
                                        .map(schedulePlanToSchedulePlanDto::convert)
                                        .collect(Collectors.toUnmodifiableSet())
                                : null)
                                     .price(tour.calculatePrice())
                .createdAt(tour.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(tour.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(tour.getCreatedBy())
                .modifiedBy(tour.getModifiedBy())
                .build();
    }
}
