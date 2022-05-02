package razarm.tosan.repository.domain;

import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.repository.domain.tour.Tour;
import razarm.tosan.repository.domain.tour.Traveler;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class Booking extends BaseEntity implements Discountable {
    private final Instant date;
    private final String description;

    private final User user;
    private final Set<Traveler> travelers;
    private final Tour tour;

    public Booking(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Instant date, String description, User user, Set<Traveler> travelers, Tour tour) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.description = description;
        this.user = user;
        this.travelers = AppCollections.unmodifiableSet(travelers);
        this.tour = tour;
    }

    @Override
    public Integer discountRate() {
        return null;
    }

    public Instant getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public Set<Traveler> getTravelers() {
        return travelers;
    }

    public Tour getTour() {
        return tour;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new Booking(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, user, travelers, tour);
    }


    public static final class BookingBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private Instant date;
        private String description;
        private User user;
        private Set<Traveler> travelers;
        private Tour tour;

        private BookingBuilder() {
        }

        public static BookingBuilder aBooking() {
            return new BookingBuilder();
        }

        public BookingBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BookingBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public BookingBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public BookingBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public BookingBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public BookingBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public BookingBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BookingBuilder user(User user) {
            this.user = user;
            return this;
        }

        public BookingBuilder travelers(Set<Traveler> travelers) {
            this.travelers = travelers;
            return this;
        }

        public BookingBuilder tour(Tour tour) {
            this.tour = tour;
            return this;
        }

        public Booking build() {
            return new Booking(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, user, travelers, tour);
        }
    }
}
