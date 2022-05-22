package razarm.tosan.repository.mapper.tour;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.ActivityData;
import razarm.tosan.repository.domain.tour.Activity;


public class ActivityDataToActivity implements Mapper<ActivityData, Activity> {
    @Override
    public Activity convert(ActivityData activityData) {

    return Activity.ActivityBuilder.anActivity()
            .id(activityData.getId())
            .name(activityData.getName())
            .type(activityData.getType())
            .startAt(activityData.getStartAt())
            .endAt(activityData.getEndAt())
            .createdAt(activityData.getCreatedAt())
            .modifiedAt(activityData.getModifiedAt())
            .createdBy(activityData.getCreatedBy())
            .modifiedBy(activityData.getModifiedBy())
            .build();
    }
}
