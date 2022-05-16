package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.Booking;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;

public class CustomTour extends Tour{


    public CustomTour(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, TourType type, String guide, String description, String imgUrl, TourRate rate, Instant date, Set<TourCategory> categories, Booking booking, TourismManager tourismManager, Set<SchedulePlan> schedulePlans) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rate, date, categories, booking, tourismManager, schedulePlans);
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
    public Set<TourCategory> getCategories() {
        return null;
    }

    @Override
    public Set<SchedulePlan> getSchedulePlans() {
        return null;
    }

    @Override
    public TourType getTourType() {
        return null;
    }


    @Override
    public String toString() {
        return "CustomTour{" +
                "name='" + name + '\'' +
                ", guide='" + guide + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", booking=" + booking +
                ", touristManager=" + tourismManager +
                '}';
    }

    @Override
    public CustomTour cloneWithId(String id) {
        return new CustomTour(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rate, date, categories, booking, tourismManager, schedulePlans);
    }


    public static final class CustomTourBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected TourType type;
        protected String guide;
        protected String description;
        protected String imgUrl;
        protected TourRate rate;
        protected Instant date;
        protected Set<TourCategory> categories;
        protected Booking booking;
        protected TourismManager tourismManager;
        protected Set<SchedulePlan> schedulePlans;

        private CustomTourBuilder() {
        }

        public static CustomTourBuilder aCustomTour() {
            return new CustomTourBuilder();
        }

        public CustomTourBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CustomTourBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CustomTourBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public CustomTourBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CustomTourBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CustomTourBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomTourBuilder type(TourType type) {
            this.type = type;
            return this;
        }

        public CustomTourBuilder guide(String guide) {
            this.guide = guide;
            return this;
        }

        public CustomTourBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CustomTourBuilder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public CustomTourBuilder rate(TourRate rate) {
            this.rate = rate;
            return this;
        }

        public CustomTourBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public CustomTourBuilder categories(Set<TourCategory> categories) {
            this.categories = categories;
            return this;
        }

        public CustomTourBuilder booking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public CustomTourBuilder tourismManager(TourismManager tourismManager) {
            this.tourismManager = tourismManager;
            return this;
        }

        public CustomTourBuilder schedulePlans(Set<SchedulePlan> schedulePlans) {
            this.schedulePlans = schedulePlans;
            return this;
        }

        public CustomTour build() {
            return new CustomTour(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rate, date, categories, booking, tourismManager, schedulePlans);
        }
    }
}
