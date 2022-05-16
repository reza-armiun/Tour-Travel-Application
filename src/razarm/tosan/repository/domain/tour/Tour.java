package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.*;
import razarm.tosan.repository.domain.food.FoodOrder;
import razarm.tosan.repository.domain.transport.VehicleOrder;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;
import java.util.StringJoiner;

public class Tour extends BaseEntity
        implements Timeable, Costable {
    protected final String name;
    protected final TourType type;
    protected final String guide;
    protected final String description;
    protected final String imgUrl;
    protected final TourRate rate;
    protected final Instant date;
    protected final Set<TourCategory> categories;


    protected final Booking booking;
    protected final TourismManager tourismManager;
    protected final Set<SchedulePlan> schedulePlans;


    public Tour(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, TourType type, String guide, String description, String imgUrl, TourRate rate, Instant date, Set<TourCategory> categories, Booking booking, TourismManager tourismManager, Set<SchedulePlan> schedulePlans) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.guide = guide;
        this.description = description;
        this.imgUrl = imgUrl;
        this.rate = rate;
        this.date = date;
        this.categories = categories;
        this.booking = booking;
        this.tourismManager = tourismManager;
        this.schedulePlans = schedulePlans;
    }

    public String getName() {
        return name;
    }

    public TourType getType() {
        return type;
    }

    public String getGuide() {
        return guide;
    }

    public String getDescription() {
        return description;
    }

    public Instant getDate() {
        return date;
    }

    public Booking getBooking() {
        return booking;
    }

    public TourismManager getTourismManager() {
        return tourismManager;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public TourRate getRate() {
        return rate;
    }

    public Set<TourCategory> getCategories() {
        return categories;
    }

    public Set<SchedulePlan> getSchedulePlans() {
        return schedulePlans;
    }

    public TourType getTourType() {
        return type;
    }

    @Override
    public BigInteger calculatePrice() {
        return this.schedulePlans.stream()
                .map(
                        schedulePlan -> {
                            var accPrice =
                                    schedulePlan.getAccommodationOrder() != null
                                            ? schedulePlan.getAccommodationOrder().calculatePrice()
                                            : new BigInteger("0");
                            var foodPrice =
                                    schedulePlan.getFoodOrders().stream()
                                            .map(FoodOrder::calculatePrice)
                                            .reduce(new BigInteger("0"), BigInteger::add);
                            var vehiclePrice =
                                    schedulePlan.getVehicleOrders().stream()
                                            .map(VehicleOrder::calculatePrice)
                                            .reduce(new BigInteger("0"), BigInteger::add);

                            return accPrice.add(foodPrice).add(vehiclePrice);
                        })
                .reduce(new BigInteger("0"), BigInteger::add);
    }

    @Override
    public Long estimateTime() {
        return null;
    }



    @Override
    public Tour cloneWithId(String id) {
        return new Tour(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rate, date, categories, booking, tourismManager, schedulePlans);
    }

    public Tour cloneWithSchedulePlans(Set<SchedulePlan> schedulePlans) {
        return new Tour(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rate, date, categories, booking, tourismManager, schedulePlans);
    }




    @Override
    public String toString() {
        return new StringJoiner(", ", Tour.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("type=" + type)
                .add("guide='" + guide + "'")
                .add("description='" + description + "'")
                .add("date=" + date)
                .add("categories=" + categories)
                .add("booking=" + booking)
                .add("tourismManager=" + tourismManager)
                .add("schedulePlans=" + schedulePlans)
                .toString();
    }


    public static final class TourBuilder {
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

        private TourBuilder() {
        }

        public static TourBuilder aTour() {
            return new TourBuilder();
        }

        public TourBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TourBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TourBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TourBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TourBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TourBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TourBuilder type(TourType type) {
            this.type = type;
            return this;
        }

        public TourBuilder guide(String guide) {
            this.guide = guide;
            return this;
        }

        public TourBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TourBuilder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public TourBuilder rate(TourRate rate) {
            this.rate = rate;
            return this;
        }

        public TourBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public TourBuilder categories(Set<TourCategory> categories) {
            this.categories = categories;
            return this;
        }

        public TourBuilder booking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public TourBuilder tourismManager(TourismManager tourismManager) {
            this.tourismManager = tourismManager;
            return this;
        }

        public TourBuilder schedulePlans(Set<SchedulePlan> schedulePlans) {
            this.schedulePlans = schedulePlans;
            return this;
        }

        public Tour build() {
            return new Tour(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rate, date, categories, booking, tourismManager, schedulePlans);
        }
    }
}
