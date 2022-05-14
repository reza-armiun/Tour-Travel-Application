package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.ActivityDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.tour.Activity;

import java.time.ZoneId;

public class ActivityToActivityDto implements Mapper<Activity, ActivityDto> {
    @Override
    public ActivityDto convert(Activity activity) {
        return ActivityDto.ActivityDtoBuilder.anActivityDto()
                .id(activity.getId())
                .name(activity.getName())
                .type(activity.getType())
                .startAt(activity.getStartAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .endAt(activity.getEndAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdAt(activity.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(activity.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(activity.getCreatedBy())
                .modifiedBy(activity.getModifiedBy())
                .build();
    }
}
