package razarm.tosan.repository;

import razarm.tosan.repository.CrudRepository;
import razarm.tosan.repository.domain.tour.Tour;
import razarm.tosan.repository.domain.tour.TourType;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, String> {

    List<Tour> findAllByType(TourType type);
}
