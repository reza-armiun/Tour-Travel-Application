package razarm.tosan.repository.data.tour;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.data.location.AddressData;

import java.time.Instant;
import java.util.Set;
import java.util.StringJoiner;

public class SchedulePlanData extends BaseEntityData {
    private final String name;
    private final Instant startTime;
    private final Instant arrivalTime;
    private final AddressData source;
    private final AddressData destination;

    private final Set<ActivityData> activities ;

    private final String accommodationOrderId;
    private final Set<String> vehicleOrderIds;
    private final Set<String> foodOrderIds;


    public SchedulePlanData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Instant startTime, Instant arrivalTime, AddressData source, AddressData destination, Set<ActivityData> activities, String accommodationOrderId, Set<String> vehicleOrderIds, Set<String> foodOrderIds) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.source = source;
        this.destination = destination;
        this.activities = activities;
        this.accommodationOrderId = accommodationOrderId;
        this.vehicleOrderIds = vehicleOrderIds;
        this.foodOrderIds = foodOrderIds;
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

    public AddressData getSource() {
        return source;
    }

    public AddressData getDestination() {
        return destination;
    }

    public Set<ActivityData> getActivities() {
        return activities;
    }

    public String getAccommodationOrderId() {
        return accommodationOrderId;
    }

    public Set<String> getVehicleOrderIds() {
        return vehicleOrderIds;
    }

    public Set<String> getFoodOrderIds() {
        return foodOrderIds;
    }

    @Override
    public SchedulePlanData cloneWithId(String id) {
        return new SchedulePlanData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodationOrderId, vehicleOrderIds, foodOrderIds);
    }




    public static final class SchedulePlanDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private Instant startTime;
        private Instant arrivalTime;
        private AddressData source;
        private AddressData destination;
        private Set<ActivityData> activities ;
        private String accommodationOrderId;
        private Set<String> vehicleOrderIds;
        private Set<String> foodOrderIds;

        private SchedulePlanDataBuilder() {
        }

        public static SchedulePlanDataBuilder aSchedulePlanData() {
            return new SchedulePlanDataBuilder();
        }

        public SchedulePlanDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SchedulePlanDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public SchedulePlanDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public SchedulePlanDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public SchedulePlanDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public SchedulePlanDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SchedulePlanDataBuilder startTime(Instant startTime) {
            this.startTime = startTime;
            return this;
        }

        public SchedulePlanDataBuilder arrivalTime(Instant arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public SchedulePlanDataBuilder source(AddressData source) {
            this.source = source;
            return this;
        }

        public SchedulePlanDataBuilder destination(AddressData destination) {
            this.destination = destination;
            return this;
        }

        public SchedulePlanDataBuilder activities(Set<ActivityData> activities) {
            this.activities = activities;
            return this;
        }

        public SchedulePlanDataBuilder accommodationOrderId(String accommodationOrderId) {
            this.accommodationOrderId = accommodationOrderId;
            return this;
        }

        public SchedulePlanDataBuilder vehicleOrderIds(Set<String> vehicleOrderIds) {
            this.vehicleOrderIds = vehicleOrderIds;
            return this;
        }

        public SchedulePlanDataBuilder foodOrderIds(Set<String> foodOrderIds) {
            this.foodOrderIds = foodOrderIds;
            return this;
        }

        public SchedulePlanData build() {
            return new SchedulePlanData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodationOrderId, vehicleOrderIds, foodOrderIds);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SchedulePlanData.class.getSimpleName() + "[", "]")
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
                .add("accommodationOrderId='" + accommodationOrderId + "'")
                .add("vehicleOrderIds=" + vehicleOrderIds)
                .add("foodOrderIds=" + foodOrderIds)
                .toString();
    }
}
