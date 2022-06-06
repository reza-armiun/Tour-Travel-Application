package razarm.tosan.repository.inMemoryImpl.tour;

import org.springframework.stereotype.Repository;
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

@Repository
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

}
