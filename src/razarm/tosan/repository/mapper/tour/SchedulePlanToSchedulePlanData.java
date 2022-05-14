package razarm.tosan.repository.mapper.tour;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.SchedulePlanData;
import razarm.tosan.repository.domain.food.FoodOrder;
import razarm.tosan.repository.domain.tour.SchedulePlan;
import razarm.tosan.repository.domain.transport.VehicleOrder;
import razarm.tosan.repository.mapper.location.AddressToAddressData;

import java.util.stream.Collectors;

public class SchedulePlanToSchedulePlanData implements Mapper<SchedulePlan, SchedulePlanData> {
    private final AddressToAddressData addressToAddressData;
    private final ActivityToActivityData activityToActivityData;

    public SchedulePlanToSchedulePlanData(AddressToAddressData addressToAddressData, ActivityToActivityData activityToActivityData) {
        this.addressToAddressData = addressToAddressData;
        this.activityToActivityData = activityToActivityData;
    }

    @Override
    public SchedulePlanData convert(SchedulePlan schedulePlan) {
        return SchedulePlanData.SchedulePlanDataBuilder.aSchedulePlanData()
            .id(schedulePlan.getId())
            .name(schedulePlan.getName())
            .startTime(schedulePlan.getStartTime())
            .arrivalTime(schedulePlan.getArrivalTime())
            .source(addressToAddressData.convert(schedulePlan.getSource()))
            .destination(addressToAddressData.convert(schedulePlan.getDestination()))
            .activities(
                schedulePlan.getActivities().stream()
                    .map(activityToActivityData::convert)
                    .collect(Collectors.toUnmodifiableSet()))
            .accommodationOrderId(
                schedulePlan.getAccommodationOrder() != null
                    ? schedulePlan.getAccommodationOrder().getId()
                    : null)
            .vehicleOrderIds(
                schedulePlan.getVehicleOrders().stream()
                    .map(VehicleOrder::getId)
                    .collect(Collectors.toUnmodifiableSet()))
            .foodOrderIds(
                schedulePlan.getFoodOrders().stream()
                    .map(FoodOrder::getId)
                    .collect(Collectors.toUnmodifiableSet()))
            .createdAt(schedulePlan.getCreatedAt())
            .modifiedAt(schedulePlan.getModifiedAt())
            .createdBy(schedulePlan.getCreatedBy())
            .modifiedBy(schedulePlan.getModifiedBy())
            .build();
    }
}
