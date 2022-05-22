package razarm.tosan.service.tour;

public interface TourRateService {

    void rateTour(String username, String tourId, int rate);

    Float getTourRate(String tourId);

}
