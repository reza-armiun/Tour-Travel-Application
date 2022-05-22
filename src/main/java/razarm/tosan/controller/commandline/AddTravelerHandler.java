package razarm.tosan.controller.commandline;

import razarm.tosan.controller.commandline.question.BookingQuestionFactory;
import razarm.tosan.controller.commandline.question.QuestionFactory;
import razarm.tosan.controller.dto.tour.TravelerDto;


import java.util.*;

public class AddTravelerHandler extends QuestionHandler {

    public static final String NAME = "ADD TRAVELER";

    public AddTravelerHandler(Map<String, QuestionHandler> questionHandlers) {
        super(questionHandlers);
    }

    @Override
    public void run(Map<String, Object> values) {

        TravelerDto traveler;
        while (true) {
            traveler = BookingQuestionFactory.createTraveler();

            TableGenerator tableGenerator = new TableGenerator();

            List<String> headersList = new ArrayList<>();
            headersList.add("Name");
            headersList.add("Phone");
            headersList.add("Email");
            headersList.add("National Id");

            List<List<String>> rowsList = new ArrayList<>();

            for (int i = 0; i < 1; i++) {
                List<String> row = new ArrayList<>();
                row.add(traveler.getName());
                row.add(traveler.getPhone());
                row.add(traveler.getEmail());
                row.add(traveler.getNationalId().toString());

                rowsList.add(row);
            }

            System.out.println("Traveler Info");
            System.out.println(tableGenerator.generateTable(headersList, rowsList));

            var result  = QuestionFactory.confirmationQuestion("Are you sure?");

            if(result) {
                break;
            }
        }

        values.put("traveler", traveler);
        nextQuestion(values);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
