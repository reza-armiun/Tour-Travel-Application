package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.accommodation.Accommodation;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.repository.domain.transport.VehicleOrder;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class SchedulePlan extends BaseEntity {
    private final String name;
    private final Instant startTime;
    private final Instant arrivalTime;
    private final Address source;
    private final Address destination;


    private final Set<Activity> activities ; //TODO use ordered set
    private final Accommodation accommodation;

    private final Set<VehicleOrder> vehicleOrders;

    public SchedulePlan(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Instant startTime, Instant arrivalTime, Address source, Address destination, Set<Activity> activities, Accommodation accommodation, Set<VehicleOrder> vehicleOrders) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.source = source;
        this.destination = destination;
        this.activities = AppCollections.unmodifiableSet(activities);
        this.accommodation = accommodation;
        this.vehicleOrders = AppCollections.unmodifiableSet(vehicleOrders);
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

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public Set<VehicleOrder> getVehicleSchedules() {
        return vehicleOrders;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new SchedulePlan(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodation, vehicleOrders);
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
        private Accommodation accommodation;
        private Set<VehicleOrder> vehicleOrders;

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

        public SchedulePlanBuilder accommodation(Accommodation accommodation) {
            this.accommodation = accommodation;
            return this;
        }

        public SchedulePlanBuilder vehicleOrders(Set<VehicleOrder> vehicleOrders) {
            this.vehicleOrders = vehicleOrders;
            return this;
        }

        public SchedulePlan build() {
            return new SchedulePlan(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodation, vehicleOrders);
        }
    }
}
