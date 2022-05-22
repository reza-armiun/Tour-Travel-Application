package razarm.tosan.service.tour;

import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.service.CrudService;

import java.util.List;

public interface TourService extends CrudService<TourDto, String> {

    List<TourDto> findAllByType(TourType type);
}
