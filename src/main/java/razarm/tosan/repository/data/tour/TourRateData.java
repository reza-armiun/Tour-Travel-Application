package razarm.tosan.repository.data.tour;

import java.time.Instant;
import java.util.Objects;

public class TourRateData {
    private final String username;
    private final String tourId;
    private final Integer rating;
    private final Instant date;

    public TourRateData(String username, String tourId, Integer rating, Instant date) {
        this.username = username;
        this.tourId = tourId;
        this.rating = rating;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public String getTourId() {
        return tourId;
    }

    public Integer getRating() {
        return rating;
    }

    public Instant getDate() {
        return date;
    }


    public static final class TourRateDataBuilder {
        private String username;
        private String tourId;
        private Integer rating;
        private Instant date;

        private TourRateDataBuilder() {
        }

        public static TourRateDataBuilder aTourRateData() {
            return new TourRateDataBuilder();
        }

        public TourRateDataBuilder username(String username) {
            this.username = username;
            return this;
        }

        public TourRateDataBuilder tourId(String tourId) {
            this.tourId = tourId;
            return this;
        }

        public TourRateDataBuilder rating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public TourRateDataBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public TourRateData build() {
            return new TourRateData(username, tourId, rating, date);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRateData that = (TourRateData) o;
        return username.equals(that.username) && tourId.equals(that.tourId) && rating.equals(that.rating) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, tourId, rating, date);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TourRateData{");
        sb.append("username='").append(username).append('\'');
        sb.append(", tourId='").append(tourId).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
