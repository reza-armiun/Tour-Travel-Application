package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.ActivityDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.tour.Activity;

public class ActivityDtoToActivity implements Mapper<ActivityDto, Activity> {
    @Override
    public Activity convert(ActivityDto activityDto) {
    return Activity.ActivityBuilder.anActivity()
            .id(activityDto.getId())
            .name(activityDto.getName())
            .type(activityDto.getType())
            .startAt(activityDto.getStartAt().toInstant())
            .endAt(activityDto.getEndAt().toInstant())
            .createdAt(activityDto.getCreatedAt().toInstant())
            .modifiedAt(activityDto.getModifiedAt().toInstant())
            .createdBy(activityDto.getCreatedBy())
            .modifiedBy(activityDto.getModifiedBy())
            .build();
    }
}
