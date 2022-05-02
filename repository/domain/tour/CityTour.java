package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Booking;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;

public class CityTour extends Tour {
    protected final TourType type = TourType.CITY;

    public CityTour(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String guide, String description, Instant date, Set<TourCategory> categories, Booking booking, TourismManager tourismManager, Set<SchedulePlan> schedulePlans) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, TourType.CITY, guide, description, date, categories, booking, tourismManager, schedulePlans);
    }

    @Override
    public BigInteger calculatePrice() {
        return null;
    }

    @Override
    public Long estimateTime() {
        return null;
    }

    @Override
    Set<TourCategory> getCategories() {
        return Set.of(TourCategory.CITY, TourCategory.TOURIST);
    }

    @Override
    Set<SchedulePlan> getSchedulePlans() {
        return null;
    }

    @Override
    TourType getTourType() {
        return TourType.CITY;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new CityTour(id, createdAt, modifiedAt, createdBy, modifiedBy, name, guide, description, date, categories, booking, tourismManager, schedulePlans);
    }


    public static final class CityTourBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected TourType type = TourType.CITY;
        protected String name;
        protected String guide;
        protected String description;
        protected Instant date;
        protected Set<TourCategory> categories;
        protected Booking booking;
        protected TourismManager tourismManager;
        protected Set<SchedulePlan> schedulePlans;

        private CityTourBuilder() {
        }

        public static CityTourBuilder aCityTour() {
            return new CityTourBuilder();
        }

        public CityTourBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CityTourBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CityTourBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CityTourBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CityTourBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CityTourBuilder type(TourType type) {
            this.type = type;
            return this;
        }

        public CityTourBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CityTourBuilder guide(String guide) {
            this.guide = guide;
            return this;
        }

        public CityTourBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CityTourBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public CityTourBuilder categories(Set<TourCategory> categories) {
            this.categories = categories;
            return this;
        }

        public CityTourBuilder booking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public CityTourBuilder tourismManager(TourismManager tourismManager) {
            this.tourismManager = tourismManager;
            return this;
        }

        public CityTourBuilder schedulePlans(Set<SchedulePlan> schedulePlans) {
            this.schedulePlans = schedulePlans;
            return this;
        }

        public CityTour build() {
            CityTour cityTour = new CityTour(id, createdAt, modifiedAt, createdBy, modifiedBy, name, guide, description, date, categories, booking, tourismManager, schedulePlans);
            return cityTour;
        }
    }
}
