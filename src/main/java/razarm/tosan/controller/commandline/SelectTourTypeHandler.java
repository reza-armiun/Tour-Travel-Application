package razarm.tosan.controller.commandline;

import razarm.tosan.controller.commandline.question.QuestionFactory;
import razarm.tosan.repository.domain.tour.TourType;

import java.util.*;


public class SelectTourTypeHandler extends QuestionHandler{
    public static final String NAME = "SELECT TOUR TYPE";

    public SelectTourTypeHandler(Map<String, QuestionHandler> questionHandlers) {
        super(questionHandlers);
    }

    @Override
    public void run(Map<String, Object> values) {

    var selectedTourType =
        TourType.valueOf(
            QuestionFactory.selectOptions(
                Arrays.stream(TourType.values()).map(Enum::toString).toArray(String[]::new)));

    if(values == null) values = new HashMap<>();
    values.put("type", selectedTourType);
    nextQuestion(values);


    }

    @Override
    public String getName() {
        return NAME;
    }

}