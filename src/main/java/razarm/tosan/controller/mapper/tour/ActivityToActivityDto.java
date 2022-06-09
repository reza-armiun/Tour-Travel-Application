package razarm.tosan.controller.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.ActivityDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.tour.Activity;

import java.time.ZoneId;
@Component
public class ActivityToActivityDto implements Mapper<Activity, ActivityDto> {
    @Override
    public ActivityDto convert(Activity activity) {
        return ActivityDto.ActivityDtoBuilder.anActivityDto()
                .id(activity.getId())
                .name(activity.getName())
                .type(activity.getType())
                .startAt(activity.getStartAt() != null ? activity.getStartAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)) : null)
                .endAt(activity.getEndAt() != null ? activity.getEndAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)) : null)
                .createdAt(activity.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(activity.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(activity.getCreatedBy())
                .modifiedBy(activity.getModifiedBy())
                .build();
    }
}
