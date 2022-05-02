package razarm.tosan.service.tour;

import razarm.tosan.controller.dto.tour.ActivityDto;
import razarm.tosan.controller.dto.tour.SchedulePlanDto;

import java.util.List;

public interface TourScheduleService {
    SchedulePlanDto addTourSchedule(String tourId, SchedulePlanDto schedulePlanDto);
    void updateTourSchedule(SchedulePlanDto schedulePlanDto);
    void removeTourSchedule(String tourId, String scheduleId);
    List<SchedulePlanDto> findAllTourSchedules(String tourId);

    ActivityDto addActivityToTourSchedule(String tourScheduleId, ActivityDto activityDto);
    void updateTourScheduleActivity(String tourScheduleId, ActivityDto activityDto);
    void deleteTourScheduleActivity(String tourScheduleId, String activityId);
    List<ActivityDto> findAllTourScheduleActivities();
}
