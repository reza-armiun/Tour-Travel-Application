package razarm.tosan.repository.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TourRateData;
import razarm.tosan.repository.domain.tour.Tour;
import razarm.tosan.repository.domain.tour.TourRate;

@Component
public class TourRateDataToTourRate implements Mapper<TourRateData, TourRate> {
    @Override
    public TourRate convert(TourRateData tourRateData) {
        return TourRate.TourRateBuilder.aTourRate()
                                       .date(tourRateData.getDate())
                                       .rating(tourRateData.getRating())
                                       .username(tourRateData.getUsername())
                                       .tour(Tour.TourBuilder.aTour().id(tourRateData.getTourId()).build())
                                       .build();
    }
}
