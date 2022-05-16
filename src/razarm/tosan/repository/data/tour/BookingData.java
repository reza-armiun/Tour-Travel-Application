package razarm.tosan.repository.data.tour;

import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;
import java.util.Set;

public class BookingData extends BaseEntityData {

    private final Instant date;
    private final String description;
    private final String userId;
    private final Set<TravelerData> travelers;
    private final String tourId;

    public BookingData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Instant date, String description, String userId, Set<TravelerData> travelers, String tourId) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.description = description;
        this.userId = userId;
        this.travelers = travelers;
        this.tourId = tourId;
    }

    public Instant getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public Set<TravelerData> getTravelers() {
        return travelers;
    }


    public String getTourId() {
        return tourId;
    }

    @Override
    public BookingData cloneWithId(String id) {
        return new BookingData(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, userId, travelers, tourId);
    }



    public static final class BookingDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private Instant date;
        private String description;
        private String userId;
        private Set<TravelerData> travelers;
        private String tourId;

        private BookingDataBuilder() {
        }

        public static BookingDataBuilder aBookingData() {
            return new BookingDataBuilder();
        }

        public BookingDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BookingDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public BookingDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public BookingDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public BookingDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public BookingDataBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public BookingDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BookingDataBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public BookingDataBuilder travelers(Set<TravelerData> travelers) {
            this.travelers = travelers;
            return this;
        }

        public BookingDataBuilder tourId(String tourId) {
            this.tourId = tourId;
            return this;
        }

        public BookingData build() {
            return new BookingData(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, userId, travelers, tourId);
        }
    }
}
