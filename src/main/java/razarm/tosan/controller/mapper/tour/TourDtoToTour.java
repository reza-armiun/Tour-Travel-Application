package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.tour.Tour;

import java.util.stream.Collectors;

public class TourDtoToTour implements Mapper<TourDto, Tour> {
    private final TourismManagerDtoToTourismManager tourismManagerDtoToTourismManager;
    private final SchedulePlanDtoToSchedulePlan schedulePlanDtoToSchedulePlan;

    public TourDtoToTour(TourismManagerDtoToTourismManager tourismManagerDtoToTourismManager, SchedulePlanDtoToSchedulePlan schedulePlanDtoToSchedulePlan) {
        this.tourismManagerDtoToTourismManager = tourismManagerDtoToTourismManager;
        this.schedulePlanDtoToSchedulePlan = schedulePlanDtoToSchedulePlan;
    }

    @Override
    public Tour convert(TourDto tourDto) {
        return Tour.TourBuilder.aTour()
                .id(tourDto.getId())
                .name(tourDto.getName())
                .type(tourDto.getType())
                .guide(tourDto.getGuide())
                .description(tourDto.getDescription())
                .imgUrl(tourDto.getImgUrl())
                .date(tourDto.getDate().toInstant())
                .categories(tourDto.getCategories())
                .tourismManager(tourismManagerDtoToTourismManager.convert(tourDto.getTourismManager()))
                .schedulePlans(tourDto.getSchedulePlans().stream().map(schedulePlanDtoToSchedulePlan::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(tourDto.getCreatedAt().toInstant())
                .modifiedAt(tourDto.getModifiedAt().toInstant())
                .createdBy(tourDto.getCreatedBy())
                .modifiedBy(tourDto.getModifiedBy())
                .build();
    }
}
