package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.mapper.tour.TourDtoToTour;
import razarm.tosan.controller.mapper.tour.TourToTourDto;
import razarm.tosan.repository.TourRateRepository;
import razarm.tosan.repository.TourRepository;
import razarm.tosan.repository.domain.tour.TourRate;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.service.tour.TourService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourToTourDto tourToTourDto;
    private final TourDtoToTour tourDtoToTour;
    private final TourRateRepository tourRateRepository;

    public TourServiceImpl(TourRepository tourRepository, TourToTourDto tourToTourDto, TourDtoToTour tourDtoToTour, TourRateRepository tourRateRepository) {
        this.tourRepository = tourRepository;
        this.tourToTourDto = tourToTourDto;
        this.tourDtoToTour = tourDtoToTour;
        this.tourRateRepository = tourRateRepository;
    }

    @Override
    public TourDto create(TourDto tourDto) {
        var tour = tourDtoToTour.convert(tourDto);
        var savedTour = tourRepository.save(tour);
        return tourToTourDto.convert(savedTour);
    }

    @Override
    public void update(TourDto tourDto) {
        var tour = tourDtoToTour.convert(tourDto);
        tourRepository.update(tour);
    }

    @Override
    public TourDto findById(String s) {

        TourDto tourDto = tourToTourDto.convert(tourRepository.findById(s));

        return tourDto.cloneWithRating(getTourRating(s));
    }

    @Override
    public void deleteById(String s) {
        tourRepository.deleteById(s);
    }

    @Override
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
