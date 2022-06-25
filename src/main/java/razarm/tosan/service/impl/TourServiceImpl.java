package razarm.tosan.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.mapper.tour.TourDtoToTour;
import razarm.tosan.controller.mapper.tour.TourToTourDto;
import razarm.tosan.repository.*;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;
import razarm.tosan.repository.domain.food.FoodOrder;
import razarm.tosan.repository.domain.tour.SchedulePlan;
import razarm.tosan.repository.domain.tour.TourRate;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.repository.domain.transport.VehicleOrder;
import razarm.tosan.service.tour.TourService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourToTourDto tourToTourDto;
    private final TourDtoToTour tourDtoToTour;
    private final TourRateRepository tourRateRepository;
    private final AccommodationOrderRepository accommodationOrderRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final VehicleOrderRepository vehicleOrderRepository;

    public TourServiceImpl(TourRepository tourRepository, TourToTourDto tourToTourDto, TourDtoToTour tourDtoToTour, TourRateRepository tourRateRepository, AccommodationOrderRepository accommodationOrderRepository, FoodOrderRepository foodOrderRepository, VehicleOrderRepository vehicleOrderRepository) {
        this.tourRepository = tourRepository;
        this.tourToTourDto = tourToTourDto;
        this.tourDtoToTour = tourDtoToTour;
        this.tourRateRepository = tourRateRepository;
        this.accommodationOrderRepository = accommodationOrderRepository;
        this.foodOrderRepository = foodOrderRepository;
        this.vehicleOrderRepository = vehicleOrderRepository;
    }

    @Override
    @CacheEvict(value = "tours" ,allEntries = true)
    public TourDto create(TourDto tourDto) {
        var tour = tourDtoToTour.convert(tourDto);
        var plans = tour.getSchedulePlans();
        var planeWithSavedOrders = plans.stream()
                                        .map(this::getSchedulePlan).collect(Collectors.toUnmodifiableSet());

        var savedTour = tourRepository.save(tour.cloneWithSchedulePlans(planeWithSavedOrders));
        return tourToTourDto.convert(savedTour);
    }

    private SchedulePlan getSchedulePlan(SchedulePlan schedulePlan) {
        AccommodationOrder accOrder;
        Set<VehicleOrder> vehicleOrders;
        Set<FoodOrder> foodOrders;
        if (schedulePlan.getAccommodationOrder().getId() == null) {
            accOrder =
                    this.accommodationOrderRepository.save(
                            schedulePlan.getAccommodationOrder());
        } else accOrder = schedulePlan.getAccommodationOrder();

        vehicleOrders =
                schedulePlan.getVehicleOrders().stream()
                            .map(
                                vehicleOrder -> {
                                    if (vehicleOrder.getId() == null) {
                                        return this.vehicleOrderRepository
                                                .save(vehicleOrder);
                                    }
                                    return vehicleOrder;
                                })
                            .collect(Collectors.toUnmodifiableSet());
        foodOrders =
                schedulePlan.getFoodOrders().stream()
                            .map(
                                foodOrder -> {
                                    if (foodOrder.getId() == null) {
                                        return this.foodOrderRepository.save(
                                                foodOrder);
                                    }
                                    return foodOrder;
                                })
                            .collect(Collectors.toUnmodifiableSet());
        return schedulePlan
                .cloneWithAccommodation(accOrder)
                .cloneWithFoodOrders(foodOrders)
                .cloneWithVehicleOrders(vehicleOrders);
    }

    @Override
    @CacheEvict(value = "tours" ,allEntries = true)
    public void update(TourDto tourDto) {
        var tour = tourDtoToTour.convert(tourDto);
        tourRepository.update(tour);
    }

    @Override
    @Cacheable(value = "tours")
    public TourDto findById(String s) {

        TourDto tourDto = tourToTourDto.convert(tourRepository.findById(s));

        return tourDto.cloneWithRating(getTourRating(s));
    }

    @Override
    @CacheEvict(value = "tours" ,allEntries = true)
    public void deleteById(String s) {
        tourRepository.deleteById(s);
    }

    @Override
    @Cacheable(value = "tours")
    public List<TourDto> findAll() {
        return tourRepository.findAll().stream()
                .map(tourToTourDto::convert)
                .map(tourDto -> tourDto.cloneWithRating(getTourRating(tourDto.getId())))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<TourDto> findAllByType(TourType type) {
        return tourRepository.findAllByType(type).stream()
                .map(tourToTourDto::convert)
                .map(tourDto -> tourDto.cloneWithRating(getTourRating(tourDto.getId())))
                .collect(Collectors.toUnmodifiableList());
    }

    private Float getTourRating(String tourId) {
        var rateList = tourRateRepository.getAllTourRates(tourId);
        var size = rateList.size();
        var sum = rateList.stream().map(TourRate::getRating).reduce(0 , Integer::sum);
        return   (float) sum/ (float) size;
    }
}
