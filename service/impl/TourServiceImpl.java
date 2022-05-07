package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.mapper.tour.TourDtoToTour;
import razarm.tosan.controller.mapper.tour.TourToTourDto;
import razarm.tosan.repository.TourRepository;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.service.tour.TourService;

import java.util.List;
import java.util.stream.Collectors;

public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final TourToTourDto tourToTourDto;
    private final TourDtoToTour tourDtoToTour;

    public TourServiceImpl(TourRepository tourRepository, TourToTourDto tourToTourDto, TourDtoToTour tourDtoToTour) {
        this.tourRepository = tourRepository;
        this.tourToTourDto = tourToTourDto;
        this.tourDtoToTour = tourDtoToTour;
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
        return tourToTourDto.convert(tourRepository.findById(s));
    }

    @Override
    public void deleteById(String s) {
        tourRepository.deleteById(s);
    }

    @Override
    public List<TourDto> findAll() {
        return tourRepository.findAll().stream()
                .map(tourToTourDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<TourDto> findAllByType(TourType type) {
        return tourRepository.findAllByType(type).stream()
                .map(tourToTourDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }
}
