package razarm.tosan.repository.mapper.tour;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.TourRateData;
import razarm.tosan.repository.domain.tour.TourRate;

public class TourRateToTourRateData implements Mapper<TourRate, TourRateData> {
    @Override
    public TourRateData convert(TourRate tourRate) {
        return TourRateData.TourRateDataBuilder.aTourRateData()
                                               .tourId(tourRate.getTour().getId())
                                               .date(tourRate.getDate())
                                               .username(tourRate.getUsername())
                                               .rating(tourRate.getRating())
                                               .build();
    }
}
