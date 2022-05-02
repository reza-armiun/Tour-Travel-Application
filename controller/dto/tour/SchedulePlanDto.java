package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.accommodation.AccommodationDto;
import razarm.tosan.controller.dto.transport.VehicleOrderDto;

import java.time.ZonedDateTime;
import java.util.Set;

public  class SchedulePlanDto extends BaseEntityDto {
    private final String name;
    private final ZonedDateTime startTime;
    private final ZonedDateTime arrivalTime;
    private final AddressDto source;
    private final AddressDto destination;

    private final Set<ActivityDto> activities;
    private final AccommodationDto accommodation;
    private final Set<VehicleOrderDto> vehicleOrders;


    public SchedulePlanDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, ZonedDateTime startTime, ZonedDateTime arrivalTime, AddressDto source, AddressDto destination, Set<ActivityDto> activities, AccommodationDto accommodation, Set<VehicleOrderDto> vehicleOrders) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.source = source;
        this.destination = destination;
        this.activities = activities;
        this.accommodation = accommodation;
        this.vehicleOrders = vehicleOrders;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ZonedDateTime getArrivalTime() {
        return arrivalTime;
    }

    public AddressDto getSource() {
        return source;
    }

    public AddressDto getDestination() {
        return destination;
    }

    public Set<ActivityDto> getActivities() {
        return activities;
    }

    public AccommodationDto getAccommodation() {
        return accommodation;
    }

    public Set<VehicleOrderDto> getVehicleOrders() {
        return vehicleOrders;
    }

    public static final class SchedulePlanDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private ZonedDateTime startTime;
        private ZonedDateTime arrivalTime;
        private AddressDto source;
        private AddressDto destination;
        private Set<ActivityDto> activities;
        private AccommodationDto accommodation;
        private Set<VehicleOrderDto> vehicleOrders;

        private SchedulePlanDtoBuilder() {
        }

        public static SchedulePlanDtoBuilder aSchedulePlanDto() {
            return new SchedulePlanDtoBuilder();
        }

        public SchedulePlanDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SchedulePlanDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public SchedulePlanDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public SchedulePlanDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public SchedulePlanDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public SchedulePlanDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SchedulePlanDtoBuilder startTime(ZonedDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public SchedulePlanDtoBuilder arrivalTime(ZonedDateTime arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public SchedulePlanDtoBuilder source(AddressDto source) {
            this.source = source;
            return this;
        }

        public SchedulePlanDtoBuilder destination(AddressDto destination) {
            this.destination = destination;
            return this;
        }

        public SchedulePlanDtoBuilder activities(Set<ActivityDto> activities) {
            this.activities = activities;
            return this;
        }

        public SchedulePlanDtoBuilder accommodation(AccommodationDto accommodation) {
            this.accommodation = accommodation;
            return this;
        }

        public SchedulePlanDtoBuilder vehicleOrders(Set<VehicleOrderDto> vehicleOrders) {
            this.vehicleOrders = vehicleOrders;
            return this;
        }

        public SchedulePlanDto build() {
            return new SchedulePlanDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, activities, accommodation, vehicleOrders);
        }
    }
}
