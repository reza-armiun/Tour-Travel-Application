package razarm.tosan.controller.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.ActivityDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.tour.Activity;
@Component
public class ActivityDtoToActivity implements Mapper<ActivityDto, Activity> {
    @Override
    public Activity convert(ActivityDto activityDto) {
    return Activity.ActivityBuilder.anActivity()
            .id(activityDto.getId())
            .name(activityDto.getName())
            .type(activityDto.getType())
            .startAt(activityDto.getStartAt() != null ? activityDto.getStartAt().toInstant() : null)
            .endAt(activityDto.getEndAt() != null ? activityDto.getEndAt().toInstant() : null)
            .createdAt(activityDto.getCreatedAt().toInstant())
            .modifiedAt(activityDto.getModifiedAt().toInstant())
            .createdBy(activityDto.getCreatedBy())
            .modifiedBy(activityDto.getModifiedBy())
            .build();
    }
}
