package razarm.tosan.repository.mapper.tour;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TourData;
import razarm.tosan.repository.domain.tour.Tour;

import java.util.stream.Collectors;

public class TourToTourData implements Mapper<Tour, TourData> {
    private final TourismManagerToTourismManagerData tourismManagerToTourismManagerData;
    private final SchedulePlanToSchedulePlanData schedulePlanToSchedulePlanData;


    public TourToTourData(TourismManagerToTourismManagerData tourismManagerToTourismManagerData, SchedulePlanToSchedulePlanData schedulePlanToSchedulePlanData) {
        this.tourismManagerToTourismManagerData = tourismManagerToTourismManagerData;
        this.schedulePlanToSchedulePlanData = schedulePlanToSchedulePlanData;
    }

    @Override
    public TourData convert(Tour tour) {
        return TourData.TourDataBuilder.aTourData()
                .id(tour.getId())
                .name(tour.getName())
                .type(tour.getType())
                .guide(tour.getGuide())
                .description(tour.getDescription())
                .date(tour.getDate())
                .categories(tour.getCategories())
                .tourismManager(tourismManagerToTourismManagerData.convert(tour.getTourismManager()))
                .categories(tour.getCategories())
                .schedulePlans(tour.getSchedulePlans().stream().map(schedulePlanToSchedulePlanData::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(tour.getCreatedAt())
                .modifiedAt(tour.getModifiedAt())
                .createdBy(tour.getCreatedBy())
                .modifiedBy(tour.getModifiedBy())
                .build();
    }
}
