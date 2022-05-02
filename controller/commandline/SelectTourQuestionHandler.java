package razarm.tosan.controller.commandline;



import razarm.tosan.repository.domain.tour.TourType;

import java.util.Scanner;
import java.util.stream.IntStream;


public class SelectTourQuestionHandler extends QuestionHandler {
    private final String [] options = {"Custom Tour", " City Tour", "Village Tour"};
    private final String question = "Select Tour: ";

    public SelectTourQuestionHandler() {
    }

    @Override
    public void run(Object ...values) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println(BoldOn +TEXT_BLUE + question +TEXT_BLACK + BoldOff);

            IntStream.range(0, options.length)
                     .mapToObj(i ->  BoldOn + i + "." + BoldOff+ TEXT_YELLOW+  options[i].trim() + TEXT_BLACK + " ")
                     .forEach(System.out::print);
            System.out.println();
            Integer val = null;
            while (val == null) {
                try {
                    val = Integer.valueOf(scanner.next());
                    TourType type;
                    switch (val) {
                        case 0:
                            type = TourType.CUSTOM;
                            break;
                        case 1:
                            type = TourType.CITY;
                            break;
                        case 2:
                            type = TourType.VILLAGE;
                            break;
                        default:
                            return;
                    }
                    nextQuestion(type);  //TODO
                }catch (NumberFormatException  e) {
                    System.err.println("invalid number format, please try again");
                }
            }
        }


    }



}
