package razarm.tosan.repository.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.ActivityData;
import razarm.tosan.repository.domain.tour.Activity;
@Component
public class ActivityToActivityData implements Mapper<Activity, ActivityData> {
    @Override
    public ActivityData convert(Activity activity) {
    return ActivityData.ActivityDataBuilder.anActivityData()
            .id(activity.getId())
            .name(activity.getName())
            .type(activity.getType())
            .startAt(activity.getStartAt())
            .endAt(activity.getEndAt())
            .createdAt(activity.getCreatedAt())
            .modifiedAt(activity.getModifiedAt())
            .createdBy(activity.getCreatedBy())
            .modifiedBy(activity.getModifiedBy())
            .build();
    }
}
