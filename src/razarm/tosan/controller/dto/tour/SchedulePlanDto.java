package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.accommodation.AccommodationOrderDto;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.accommodation.AccommodationDto;
import razarm.tosan.controller.dto.food.FoodOrderDto;
import razarm.tosan.controller.dto.transport.VehicleOrderDto;
import razarm.tosan.utility.AppCollections;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.StringJoiner;

public  class SchedulePlanDto extends BaseEntityDto {
    private final String name;
    private final ZonedDateTime startTime;
    private final ZonedDateTime arrivalTime;
    private final AddressDto source;
    private final AddressDto destination;

    private final AccommodationOrderDto accommodationOrder;
    private final Set<ActivityDto> activities;
    private final Set<FoodOrderDto> foodOrders;
    private final Set<VehicleOrderDto> vehicleOrders;


    public SchedulePlanDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, ZonedDateTime startTime, ZonedDateTime arrivalTime, AddressDto source, AddressDto destination, AccommodationOrderDto accommodationOrder, Set<ActivityDto> activities, Set<FoodOrderDto> foodOrders, Set<VehicleOrderDto> vehicleOrders) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.source = source;
        this.destination = destination;
        this.accommodationOrder = accommodationOrder;
        this.activities = AppCollections.unmodifiableSet(activities);
        this.foodOrders = AppCollections.unmodifiableSet(foodOrders);
        this.vehicleOrders = AppCollections.unmodifiableSet(vehicleOrders);
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


    public AccommodationOrderDto getAccommodationOrder() {
        return accommodationOrder;
    }

    public Set<VehicleOrderDto> getVehicleOrders() {
        return vehicleOrders;
    }

    public Set<FoodOrderDto> getFoodOrders() {
        return foodOrders;
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
        private AccommodationOrderDto accommodationOrder;
        private Set<ActivityDto> activities;
        private Set<FoodOrderDto> foodOrders;
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

        public SchedulePlanDtoBuilder accommodationOrder(AccommodationOrderDto accommodationOrder) {
            this.accommodationOrder = accommodationOrder;
            return this;
        }

        public SchedulePlanDtoBuilder activities(Set<ActivityDto> activities) {
            this.activities = activities;
            return this;
        }

        public SchedulePlanDtoBuilder foodOrders(Set<FoodOrderDto> foodOrders) {
            this.foodOrders = foodOrders;
            return this;
        }

        public SchedulePlanDtoBuilder vehicleOrders(Set<VehicleOrderDto> vehicleOrders) {
            this.vehicleOrders = vehicleOrders;
            return this;
        }

        public SchedulePlanDto build() {
            return new SchedulePlanDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, startTime, arrivalTime, source, destination, accommodationOrder, activities, foodOrders, vehicleOrders);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SchedulePlanDto.class.getSimpleName() + "[", "]")
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
                .add("accommodationOrder=" + accommodationOrder)
                .add("activities=" + activities)
                .add("foodOrders=" + foodOrders)
                .add("vehicleOrders=" + vehicleOrders)
                .toString();
    }
}
