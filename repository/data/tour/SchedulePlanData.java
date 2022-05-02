package razarm.tosan.repository.data.tour;

import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;
import java.util.Set;

public class SchedulePlanData extends BaseEntityData {
    private final String name;
    private final Instant startTime;
    private final Instant arrivalTime;
    private final String sourceId;
    private final String destinationId;

    private final Set<ActivityData> activities ;

    private final String accommodationId;
    private final Set<String> vehicleOrderIds;


    public SchedulePlanData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Instant startTime, Instant arrivalTime, String sourceId, String destinationId, Set<ActivityData> activities, String accommodationId, Set<String> vehicleOrderIds) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.activities = activities;
        this.accommodationId = accommodationId;
        this.vehicleOrderIds = vehicleOrderIds;
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

    public String getSourceId() {
        return sourceId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public Set<ActivityData> getActivities() {
        return activities;
    }

    public String getAccommodationId() {
        return accommodationId;
    }

    public Set<String> getVehicleOrderIds() {
        return vehicleOrderIds;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new SchedulePlanData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, sourceId, destinationId, activities, accommodationId, vehicleOrderIds);
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
        private String sourceId;
        private String destinationId;
        private Set<ActivityData> activities ;
        private String accommodationId;
        private Set<String> vehicleOrderIds;

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

        public SchedulePlanDataBuilder sourceId(String sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        public SchedulePlanDataBuilder destinationId(String destinationId) {
            this.destinationId = destinationId;
            return this;
        }

        public SchedulePlanDataBuilder activities(Set<ActivityData> activities) {
            this.activities = activities;
            return this;
        }

        public SchedulePlanDataBuilder accommodationId(String accommodationId) {
            this.accommodationId = accommodationId;
            return this;
        }

        public SchedulePlanDataBuilder vehicleOrderIds(Set<String> vehicleOrderIds) {
            this.vehicleOrderIds = vehicleOrderIds;
            return this;
        }

        public SchedulePlanData build() {
            return new SchedulePlanData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, sourceId, destinationId, activities, accommodationId, vehicleOrderIds);
        }
    }
}
