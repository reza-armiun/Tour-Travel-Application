package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.*;

import java.time.Instant;
import java.util.Set;

public abstract class Tour extends BaseEntity
        implements Timeable, Costable {
    protected final String name;
    protected final TourType type;
    protected final String guide;
    protected  final String description;
    protected final Instant date;
    protected final Set<TourCategory> categories;


    protected final Booking booking;
    protected final TourismManager tourismManager;
    protected final Set<SchedulePlan> schedulePlans;

    abstract Set<TourCategory> getCategories();
    abstract Set<SchedulePlan> getSchedulePlans();
    abstract TourType getTourType();


    public Tour(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, TourType type, String guide, String description, Instant date, Set<TourCategory> categories, Booking booking, TourismManager tourismManager, Set<SchedulePlan> schedulePlans) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.guide = guide;
        this.description = description;
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
}
