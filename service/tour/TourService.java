package razarm.tosan.service.tour;

import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.dto.tour.TourismManagerDto;
import razarm.tosan.controller.dto.tour.TravelerDto;
import razarm.tosan.service.CrudService;

import java.util.List;

public interface TourService extends CrudService<TourDto, String> {
    @Override
    TourDto create(TourDto tourDto);

    @Override
    void update( TourDto tourDto);

    @Override
    TourDto findById(String s);

    @Override
    void deleteById(String s);

    @Override
    List<TourDto> findAll();

    TravelerDto addTraveler(String tourId, TravelerDto travelerDto);
    void updateTraveler(String tourId, TravelerDto travelerDto);
    void deleteTraveler(String tourId, String travelerId);
    List<TravelerDto> findAllTravelers(String tourId);

    TourismManagerDto addTourismManager(String tourId, TourismManagerDto tourismManagerDto);
    void updateTourismManager(String tourId, TourismManagerDto tourismManagerDto);
    void deleteTourismManager(String tourId, String tourismManagerId);
    List<TourismManagerDto> findAllTourismManagers();


}
