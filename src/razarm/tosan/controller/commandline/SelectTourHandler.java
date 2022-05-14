package razarm.tosan.controller.commandline;

import razarm.tosan.controller.commandline.question.QuestionFactory;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.service.tour.TourService;

import java.util.HashMap;
import java.util.Map;

public class SelectTourHandler extends QuestionHandler{
    public static final String NAME = "SELECT TOUR";
    private final TourService tourService;


    public SelectTourHandler(Map<String, QuestionHandler> questionHandlers, TourService tourService) {
        super(questionHandlers);
        this.tourService = tourService;
    }

    @Override
    public void run(Map<String, Object> values) {

        var tours = tourService.findAllByType((TourType) values.get("type"));
        while (true) {

            var selectedTourIndex = QuestionFactory.selectOptionsIndex("Please select a travel tour",
                    tours.stream()
                            .map(tourDto -> tourDto.getName() + " ("+ tourDto.getDescription()+ ")").toArray(String[]::new)
            );

            var tour = tours.get(selectedTourIndex);

            var answer = QuestionFactory.confirmationQuestion("Are you sure?");
            if (answer)  {
              values.put("tour", tour);
             nextQuestion(values);
             return;
            }
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
