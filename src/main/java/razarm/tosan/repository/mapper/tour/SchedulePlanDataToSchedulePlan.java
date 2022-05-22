package razarm.tosan.repository.mapper.tour;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.SchedulePlanData;
import razarm.tosan.repository.domain.tour.SchedulePlan;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;

import java.util.stream.Collectors;

public class SchedulePlanDataToSchedulePlan implements Mapper<SchedulePlanData, SchedulePlan> {
    private final AddressDataToAddress addressDataToAddress;
    private final ActivityDataToActivity activityDataToActivity;


    public SchedulePlanDataToSchedulePlan(AddressDataToAddress addressDataToAddress, ActivityDataToActivity activityDataToActivity) {
        this.addressDataToAddress = addressDataToAddress;
        this.activityDataToActivity = activityDataToActivity;
    }

    @Override
    public SchedulePlan convert(SchedulePlanData schedulePlanData) {
    return SchedulePlan.SchedulePlanBuilder.aSchedulePlan()
            .id(schedulePlanData.getId())
            .name(schedulePlanData.getName())
            .startTime(schedulePlanData.getStartTime())
            .arrivalTime(schedulePlanData.getArrivalTime())
            .source(addressDataToAddress.convert(schedulePlanData.getSource()))
            .destination(addressDataToAddress.convert(schedulePlanData.getDestination()))
            .activities(schedulePlanData.getActivities().stream().map(activityDataToActivity::convert).collect(Collectors.toUnmodifiableSet()))
            .createdAt(schedulePlanData.getCreatedAt())
            .modifiedAt(schedulePlanData.getModifiedAt())
            .createdBy(schedulePlanData.getCreatedBy())
            .modifiedBy(schedulePlanData.getModifiedBy())
            .build();
    }
}
