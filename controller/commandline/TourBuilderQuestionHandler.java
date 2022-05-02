package razarm.tosan.controller.commandline;

import razarm.tosan.repository.domain.tour.TourType;

import java.util.Arrays;

public class TourBuilderQuestionHandler extends QuestionHandler {
    @Override
    public void run(Object ...values) {
        if(values.length == 0) return;

        TourType type = (TourType) Arrays.stream(values).findFirst().get();
        switch (type) {
            case CITY:
                return;
            case VILLAGE:
                return;
            case CUSTOM:
                this.next = new SchedulePlanBuilderHandler();
                next.run();
                return;
            default:
                return;
        }
    }
}
