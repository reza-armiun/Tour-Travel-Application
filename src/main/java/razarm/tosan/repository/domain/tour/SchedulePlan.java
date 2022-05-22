package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;
import razarm.tosan.repository.domain.food.FoodOrder;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.repository.domain.transport.VehicleOrder;

import java.time.Instant;
import java.util.Set;
import java.util.StringJoiner;

public class SchedulePlan extends BaseEntity {
    private final String name;
    private final Instant startTime;
    private final Instant arrivalTime;
    private final Address source;
    private final Address destination;


    private final Set<Activity> activities ; //TODO use ordered set
    private final AccommodationOrder accommodationOrder;

    private final Set<VehicleOrder> vehicleOrders;
    private final Set<FoodOrder> foodOrders;

    public SchedulePlan(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Instant startTime, Instant arrivalTime, Address source, Address destination, Set<Activity> activities, AccommodationOrder accommodationOrder, Set<VehicleOrder> vehicleOrders, Set<FoodOrder> foodOrders) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.source = source;
        this.destination = destination;
        this.activities = activities;
        this.accommodationOrder = accommodationOrder;
        this.vehicleOrders = vehicleOrders;
        this.foodOrders = foodOrders;
    }

    public String getName() {
        return name;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public Address getSource() {
        return source;
    }

    public Address getDestination() {
        return destination;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public AccommodationOrder getAccommodationOrder() {
        return accommodationOrder;
    }

    public Set<VehicleOrder> getVehicleSchedules() {
        return vehicleOrders;
    }

    public Set<VehicleOrder> getVehicleOrders() {
        return vehicleOrders;
    }

    public Set<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    @Override
    public SchedulePlan cloneWithId(String id) {
        return new SchedulePlan(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodationOrder, vehicleOrders, foodOrders);
    }

    public SchedulePlan cloneWithVehicleOrders(Set<VehicleOrder> vehicleOrders) {
        return new SchedulePlan(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodationOrder, vehicleOrders, foodOrders);
    }
    public SchedulePlan cloneWithFoodOrders(Set<FoodOrder> foodOrders) {
        return new SchedulePlan(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodationOrder, vehicleOrders, foodOrders);
    }
    public SchedulePlan cloneWithAccommodation(AccommodationOrder accommodationOrder) {
        return new SchedulePlan(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodationOrder, vehicleOrders, foodOrders);
    }


    public static final class SchedulePlanBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private Instant startTime;
        private Instant arrivalTime;
        private Address source;
        private Address destination;
        private Set<Activity> activities ; //TODO use ordered set
        private AccommodationOrder accommodationOrder;
        private Set<VehicleOrder> vehicleOrders;
        private Set<FoodOrder> foodOrders;

        private SchedulePlanBuilder() {
        }

        public static SchedulePlanBuilder aSchedulePlan() {
            return new SchedulePlanBuilder();
        }

        public SchedulePlanBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SchedulePlanBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public SchedulePlanBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public SchedulePlanBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public SchedulePlanBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public SchedulePlanBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SchedulePlanBuilder startTime(Instant startTime) {
            this.startTime = startTime;
            return this;
        }

        public SchedulePlanBuilder arrivalTime(Instant arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public SchedulePlanBuilder source(Address source) {
            this.source = source;
            return this;
        }

        public SchedulePlanBuilder destination(Address destination) {
            this.destination = destination;
            return this;
        }

        public SchedulePlanBuilder activities(Set<Activity> activities) {
            this.activities = activities;
            return this;
        }

        public SchedulePlanBuilder accommodationOrder(AccommodationOrder accommodationOrder) {
            this.accommodationOrder = accommodationOrder;
            return this;
        }

        public SchedulePlanBuilder vehicleOrders(Set<VehicleOrder> vehicleOrders) {
            this.vehicleOrders = vehicleOrders;
            return this;
        }

        public SchedulePlanBuilder foodOrders(Set<FoodOrder> foodOrders) {
            this.foodOrders = foodOrders;
            return this;
        }

        public SchedulePlan build() {
            return new SchedulePlan(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodationOrder, vehicleOrders, foodOrders);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SchedulePlan.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("startTime=" + startTime)
                .add("arrivalTime=" + arrivalTime)
                .add("source=" + source)
                .add("destination=" + destination)
                .add("activities=" + activities)
                .add("accommodationOrder=" + accommodationOrder)
                .add("vehicleOrders=" + vehicleOrders)
                .add("foodOrders=" + foodOrders)
                .toString();
    }
}
