package razarm.tosan.repository;

import razarm.tosan.repository.domain.tour.TourRate;

import java.util.List;

public interface TourRateRepository {

    void addTourRate(String username, String tourId, int rating);

    List<TourRate> getAllTourRates(String tourId);

}
