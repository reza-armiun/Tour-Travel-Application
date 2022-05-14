package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.SchedulePlanDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.accommodation.AccOrderDtoToAccOrder;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.controller.mapper.food.FoodOrderDtoToFoodOrder;
import razarm.tosan.controller.mapper.transport.VehicleOrderDtoToVehicleOrder;
import razarm.tosan.repository.domain.tour.SchedulePlan;

import java.util.stream.Collectors;

public class SchedulePlanDtoToSchedulePlan implements Mapper<SchedulePlanDto, SchedulePlan> {
    private final ActivityDtoToActivity activityDtoToActivity;
    private final AccOrderDtoToAccOrder accOrderDtoToAccOrder;
    private final VehicleOrderDtoToVehicleOrder vehicleOrderDtoToVehicleOrder;
    private final FoodOrderDtoToFoodOrder foodOrderDtoToFoodOrder;
    private final AddressDtoToAddress addressDtoToAddress;


    public SchedulePlanDtoToSchedulePlan(ActivityDtoToActivity activityDtoToActivity, AccOrderDtoToAccOrder accOrderDtoToAccOrder, VehicleOrderDtoToVehicleOrder vehicleOrderDtoToVehicleOrder, FoodOrderDtoToFoodOrder foodOrderDtoToFoodOrder, AddressDtoToAddress addressDtoToAddress) {
        this.activityDtoToActivity = activityDtoToActivity;
        this.accOrderDtoToAccOrder = accOrderDtoToAccOrder;
        this.vehicleOrderDtoToVehicleOrder = vehicleOrderDtoToVehicleOrder;
        this.foodOrderDtoToFoodOrder = foodOrderDtoToFoodOrder;
        this.addressDtoToAddress = addressDtoToAddress;
    }

    @Override
    public SchedulePlan convert(SchedulePlanDto schedulePlanDto) {
        return SchedulePlan.SchedulePlanBuilder.aSchedulePlan()
                .id(schedulePlanDto.getId())
                .name(schedulePlanDto.getName())
                .startTime(schedulePlanDto.getStartTime().toInstant())
                .arrivalTime(schedulePlanDto.getArrivalTime().toInstant())
                .source(addressDtoToAddress.convert(schedulePlanDto.getSource()))
                .destination(addressDtoToAddress.convert(schedulePlanDto.getDestination()))
                .activities(schedulePlanDto.getActivities().stream().map(activityDtoToActivity::convert).collect(Collectors.toUnmodifiableSet()))
                .accommodationOrder(accOrderDtoToAccOrder.convert(schedulePlanDto.getAccommodationOrder()))
                .vehicleOrders(schedulePlanDto.getVehicleOrders().stream().map(vehicleOrderDtoToVehicleOrder::convert).collect(Collectors.toUnmodifiableSet()))
                .foodOrders(schedulePlanDto.getFoodOrders().stream().map(foodOrderDtoToFoodOrder::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(schedulePlanDto.getCreatedAt().toInstant())
                .modifiedAt(schedulePlanDto.getModifiedAt().toInstant())
                .createdBy(schedulePlanDto.getCreatedBy())
                .modifiedBy(schedulePlanDto.getModifiedBy())
                .build();
    }
}
