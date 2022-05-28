package razarm.tosan.service.impl;

import org.springframework.stereotype.Service;
import razarm.tosan.repository.TourRateRepository;
import razarm.tosan.repository.domain.tour.TourRate;
import razarm.tosan.service.tour.TourRateService;

@Service
public class TourRateServiceImpl implements TourRateService {
    private final TourRateRepository tourRateRepository;

    public TourRateServiceImpl(TourRateRepository tourRateRepository) {
        this.tourRateRepository = tourRateRepository;
    }

    @Override
    public void rateTour(String username, String tourId, int rate) {
         tourRateRepository.addTourRate(username, tourId, rate);
    }

    @Override
    public Float getTourRate(String tourId) {
        var rateList = tourRateRepository.getAllTourRates(tourId);
        var size = rateList.size();
        var sum = rateList.stream().map(TourRate::getRating).reduce(0 , Integer::sum);
        return (float) sum/ (float) size;
    }
}
