package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.SchedulePlanDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.accommodation.AccOrderToAccOrderDto;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.controller.mapper.food.FoodOrderToFoodOrderDto;
import razarm.tosan.controller.mapper.transport.VehicleOrderToVehicleOrderDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.tour.SchedulePlan;

import java.time.ZoneId;
import java.util.stream.Collectors;

public class SchedulePlanToSchedulePlanDto implements Mapper<SchedulePlan, SchedulePlanDto> {
    private final AddressToAddressDto addressToAddressDto;
    private final AccOrderToAccOrderDto accOrderToAccOrderDto;
    private final FoodOrderToFoodOrderDto foodOrderToFoodOrderDto;
    private final VehicleOrderToVehicleOrderDto vehicleOrderToVehicleOrderDto;
    private final ActivityToActivityDto activityToActivityDto;


    public SchedulePlanToSchedulePlanDto(AddressToAddressDto addressToAddressDto, AccOrderToAccOrderDto accOrderToAccOrderDto, FoodOrderToFoodOrderDto foodOrderToFoodOrderDto, VehicleOrderToVehicleOrderDto vehicleOrderToVehicleOrderDto, ActivityToActivityDto activityToActivityDto) {
        this.addressToAddressDto = addressToAddressDto;
        this.accOrderToAccOrderDto = accOrderToAccOrderDto;
        this.foodOrderToFoodOrderDto = foodOrderToFoodOrderDto;
        this.vehicleOrderToVehicleOrderDto = vehicleOrderToVehicleOrderDto;
        this.activityToActivityDto = activityToActivityDto;
    }

    @Override
    public SchedulePlanDto convert(SchedulePlan schedulePlan) {
        return SchedulePlanDto.SchedulePlanDtoBuilder.aSchedulePlanDto()
            .id(schedulePlan.getId())
            .name(schedulePlan.getName())
            .startTime(schedulePlan.getStartTime().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .arrivalTime(schedulePlan.getArrivalTime().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .source(addressToAddressDto.convert(schedulePlan.getSource()))
            .destination(addressToAddressDto.convert(schedulePlan.getDestination()))
            .accommodationOrder(accOrderToAccOrderDto.convert(schedulePlan.getAccommodationOrder()))
            .activities(
                schedulePlan.getActivities().stream()
                    .map(activityToActivityDto::convert)
                    .collect(Collectors.toUnmodifiableSet()))
            .foodOrders(
                schedulePlan.getFoodOrders().stream()
                    .map(foodOrderToFoodOrderDto::convert)
                    .collect(Collectors.toUnmodifiableSet()))
            .vehicleOrders(
                schedulePlan.getVehicleOrders().stream()
                    .map(vehicleOrderToVehicleOrderDto::convert)
                    .collect(Collectors.toUnmodifiableSet()))
            .createdAt(schedulePlan.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(schedulePlan.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(schedulePlan.getCreatedBy())
            .modifiedBy(schedulePlan.getModifiedBy())
            .build();
    }
}
