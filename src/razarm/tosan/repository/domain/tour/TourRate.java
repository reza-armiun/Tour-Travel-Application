package razarm.tosan.repository.domain.tour;

import java.time.Instant;
import java.util.Objects;

public class TourRate {
    private final String username;
    private final Tour tour;
    private final Integer rating;
    private final Instant date;


    public TourRate(String username, Tour tour, Integer rating, Instant date) {
        this.username = username;
        this.tour = tour;
        this.rating = rating;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public Tour getTour() {
        return tour;
    }

    public Integer getRating() {
        return rating;
    }

    public Instant getDate() {
        return date;
    }


    public static final class TourRateBuilder {
        private String username;
        private Tour tour;
        private Integer rating;
        private Instant date;

        private TourRateBuilder() {
        }

        public static TourRateBuilder aTourRate() {
            return new TourRateBuilder();
        }

        public TourRateBuilder username(String username) {
            this.username = username;
            return this;
        }

        public TourRateBuilder tour(Tour tour) {
            this.tour = tour;
            return this;
        }

        public TourRateBuilder rating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public TourRateBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public TourRate build() {
            return new TourRate(username, tour, rating, date);
        }
    }
}
