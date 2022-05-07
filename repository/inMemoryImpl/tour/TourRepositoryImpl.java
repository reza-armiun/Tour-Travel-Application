package razarm.tosan.repository.inMemoryImpl.tour;

import razarm.tosan.repository.AccommodationOrderRepository;
import razarm.tosan.repository.FoodOrderRepository;
import razarm.tosan.repository.TourRepository;
import razarm.tosan.repository.VehicleOrderRepository;
import razarm.tosan.repository.data.tour.TourData;
import razarm.tosan.repository.domain.tour.SchedulePlan;
import razarm.tosan.repository.domain.tour.Tour;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.repository.mapper.tour.SchedulePlanDataToSchedulePlan;
import razarm.tosan.repository.mapper.tour.TourDataToTour;
import razarm.tosan.repository.mapper.tour.TourToTourData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TourRepositoryImpl implements TourRepository {
    private Map<String, TourData> tourDataMap = new HashMap<>();

    private final TourToTourData tourToTourData;
    private final TourDataToTour tourDataToTour;
    private final SchedulePlanDataToSchedulePlan schedulePlanDataToSchedulePlan;

    private final AccommodationOrderRepository accommodationOrderRepository;
    private final VehicleOrderRepository vehicleOrderRepository;
    private final FoodOrderRepository foodOrderRepository;


    public TourRepositoryImpl(TourToTourData tourToTourData, TourDataToTour tourDataToTour, SchedulePlanDataToSchedulePlan schedulePlanDataToSchedulePlan, AccommodationOrderRepository accommodationOrderRepository, VehicleOrderRepository vehicleOrderRepository, FoodOrderRepository foodOrderRepository) {
        this.tourToTourData = tourToTourData;
        this.tourDataToTour = tourDataToTour;
        this.schedulePlanDataToSchedulePlan = schedulePlanDataToSchedulePlan;
        this.accommodationOrderRepository = accommodationOrderRepository;
        this.vehicleOrderRepository = vehicleOrderRepository;
        this.foodOrderRepository = foodOrderRepository;
    }

    @Override
    public Tour save(Tour tour) {
        final var tourData = tourToTourData.convert(tour);
        tourDataMap.put(tourData.getId(), tourData);
        return tour.cloneWithId(tourData.getId());
    }

    @Override
    public void update(Tour tour) {
        final var tourData = tourToTourData.convert(tour);
        tourDataMap.put(tourData.getId(), tourData);

    }

    @Override
    public void deleteById(String s) {
        tourDataMap.remove(s);
    }

    @Override
    public Tour findById(String s) {
        final var tourData = tourDataMap.get(s);
        return getTour(tourData);
    }

    @Override
    public List<Tour> findAll() {
        return tourDataMap.values().stream().map(tourData -> {
            var tour = tourDataToTour.convert(tourData);
            var tourPlans = tourData.getSchedulePlans().stream().map(schedulePlanData ->  {
                var plans = schedulePlanDataToSchedulePlan.convert(schedulePlanData);
                return plans
                        .cloneWithAccommodation(accommodationOrderRepository.findById(schedulePlanData.getAccommodationOrderId()))
                        .cloneWithVehicleOrders(schedulePlanData.getVehicleOrderIds().stream().map(vehicleOrderRepository::findById).collect(Collectors.toUnmodifiableSet()))
                        .cloneWithFoodOrders(schedulePlanData.getFoodOrderIds().stream().map(foodOrderRepository::findById).collect(Collectors.toUnmodifiableSet()));
            }).collect(Collectors.toUnmodifiableSet());
            return tour.cloneWithSchedulePlans(tourPlans);
        }).collect(Collectors.toUnmodifiableList());
    }

    private Tour getTour(TourData tourData) {
        final var tour = tourDataToTour.convert(tourData);
        final Set<SchedulePlan> schedulePlans = tourData.getSchedulePlans().stream().map(schedulePlanData -> {
            final var accommodation = accommodationOrderRepository.findById(schedulePlanData.getAccommodationOrderId());
            final var vehicleOrders = schedulePlanData.getVehicleOrderIds().stream().map(vehicleOrderRepository::findById).collect(Collectors.toUnmodifiableSet());
            final var foodOrders = schedulePlanData.getFoodOrderIds().stream().map(foodOrderRepository::findById).collect(Collectors.toUnmodifiableSet());
            return schedulePlanDataToSchedulePlan.convert(schedulePlanData).cloneWithAccommodation(accommodation).cloneWithVehicleOrders(vehicleOrders).cloneWithFoodOrders(foodOrders);
        }) .collect(Collectors.toUnmodifiableSet());
        return tour.cloneWithSchedulePlans(schedulePlans);
    }

    @Override
    public List<Tour> findAllByType(TourType type) {
        return tourDataMap.values().stream()
                .filter(tourData -> tourData.getType().equals(type))
                .map(tourData -> {
                    var tour = tourDataToTour.convert(tourData);
                    var tourPlans = tourData.getSchedulePlans().stream().map(schedulePlanData ->  {
                        var plans = schedulePlanDataToSchedulePlan.convert(schedulePlanData);
                        return plans
                                .cloneWithAccommodation(accommodationOrderRepository.findById(schedulePlanData.getAccommodationOrderId()))
                                .cloneWithVehicleOrders(schedulePlanData.getVehicleOrderIds().stream().map(vehicleOrderRepository::findById).collect(Collectors.toUnmodifiableSet()))
                                .cloneWithFoodOrders(schedulePlanData.getFoodOrderIds().stream().map(foodOrderRepository::findById).collect(Collectors.toUnmodifiableSet()));
                    }).collect(Collectors.toUnmodifiableSet());
                    return tour.cloneWithSchedulePlans(tourPlans);
                })
                .collect(Collectors.toUnmodifiableList());
    }
}
