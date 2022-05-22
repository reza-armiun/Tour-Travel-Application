package razarm.tosan.repository.inMemoryImpl.tour;

import razarm.tosan.repository.TourRateRepository;
import razarm.tosan.repository.data.tour.TourRateData;
import razarm.tosan.repository.domain.tour.TourRate;
import razarm.tosan.repository.mapper.tour.TourRateDataToTourRate;
import razarm.tosan.repository.mapper.tour.TourRateToTourRateData;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TourRateRepositoryImpl implements TourRateRepository {
//    Map<String, Map<String, TourRateData>> tourRateDataMap = new HashMap<>(); //<tourId , <username, TourData>>

    Map<Map<String, String>, TourRateData> tourRateDataMap = new HashMap<>(); // <<tourId, username> , tourData>

    private final TourRateToTourRateData tourRateToTourRateData;
    private final TourRateDataToTourRate tourRateDataToTourRate;

    public TourRateRepositoryImpl(TourRateToTourRateData tourRateToTourRateData, TourRateDataToTourRate tourRateDataToTourRate) {
        this.tourRateToTourRateData = tourRateToTourRateData;
        this.tourRateDataToTourRate = tourRateDataToTourRate;
    }

    @Override
    public void addTourRate(String username, String tourId, int rating) {
        var tourData =
                TourRateData.TourRateDataBuilder.aTourRateData()
                        .username(username)
                        .tourId(tourId)
                        .rating(rating)
                        .date(Instant.now())
                        .build();
        tourRateDataMap.put(Map.of(tourId, username), tourData);
    }

    @Override
    public List<TourRate> getAllTourRates(String tourId) {
        return tourRateDataMap.entrySet().stream()
                               .filter(
                         mapTourRateDataEntry ->
                                 mapTourRateDataEntry.getKey().containsKey(tourId))
                               .map(Map.Entry::getValue)
                               .map(tourRateDataToTourRate::convert)
                               .collect(Collectors.toUnmodifiableList());
    }
//    @Override
//    public Float addRating(String username, String tourId, int rating) {
//        var tourData = TourRateData.TourRateDataBuilder.aTourRateData().username(username).tourId(tourId).rating(rating).date(Instant.now()).build();
//        tourRateDataMap.put(tourId, Map.of(username, tourData));
//
//        var oldTourData= tourRateDataMap.get(tourId);
//        Collection<TourRateData> values = oldTourData.values();
//        var size = values.size();
//        var sum = values.stream().map(TourRateData::getRating).reduce(0, Integer::sum);
//        int rt = sum + rating;
//        var newRating = (float) rt / (float) (size + 1);
//        return newRating;
//    }
//
//    @Override
//    public Float getTourRating(String tourId) {
//        var tourData= tourRateDataMap.get(tourId);
//        Collection<TourRateData> values = tourData.values();
//        var size = values.size();
//        var sum = values.stream().map(TourRateData::getRating).reduce(0, Integer::sum);
//        var rating = (float) sum / (float) size ;
//        return rating;
//    }
}
