package razarm.tosan.repository;

import razarm.tosan.repository.domain.tour.TourRate;

import java.util.List;
import java.util.Map;

public interface TourRateRepository {
//
//    Float addRating(String username, String tourId, int rating);
//
//    Float getTourRating(String tourId);

    void addTourRate(String username, String tourId, int rating);

    List<TourRate> getAllTourRates(String tourId);

}
