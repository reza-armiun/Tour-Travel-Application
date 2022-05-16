package razarm.tosan.repository.mapper.tour;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TourData;
import razarm.tosan.repository.domain.tour.Tour;

import java.util.stream.Collectors;

public class TourDataToTour implements Mapper<TourData, Tour> {
    private final TourismManagerDataToTourismManager tourismManagerDataToTourismManager ;
    private final SchedulePlanDataToSchedulePlan scheduleplanDataToSchedulePlan;

    public TourDataToTour(TourismManagerDataToTourismManager tourismManagerDataToTourismManager, SchedulePlanDataToSchedulePlan scheduleplanDataToSchedulePlan) {
        this.tourismManagerDataToTourismManager = tourismManagerDataToTourismManager;
        this.scheduleplanDataToSchedulePlan = scheduleplanDataToSchedulePlan;
    }

    @Override
    public Tour convert(TourData tourData) {
        return Tour.TourBuilder.aTour()
                .id(tourData.getId())
                .name(tourData.getName())
                .type(tourData.getType())
                .guide(tourData.getGuide())
                .description(tourData.getDescription())
                .imgUrl(tourData.getImgUrl())
                .date(tourData.getDate())
                .categories(tourData.getCategories())
                .tourismManager(tourismManagerDataToTourismManager.convert(tourData.getTourismManager()))
                .schedulePlans(tourData.getSchedulePlans().stream().map(scheduleplanDataToSchedulePlan::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(tourData.getCreatedAt())
                .modifiedAt(tourData.getModifiedAt())
                .createdBy(tourData.getCreatedBy())
                .modifiedBy(tourData.getModifiedBy())
                .build();
    }
}
