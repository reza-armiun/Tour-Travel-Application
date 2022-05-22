package razarm.tosan;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import razarm.tosan.controller.commandline.*;
import razarm.tosan.exception.UserNotFoundException;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class Main {



    public static void main(String[] args) throws InvalidAttributeValueException, UserNotFoundException {
        SpringApplication.run(Main.class, args);
//        MockDataInitializer.initialize();
////
//        Map<String, QuestionHandler> questionHandlerMap = new HashMap<>();
//        var authQuestion = new AuthQuestionHandler(questionHandlerMap, AppContextHolder.getAuthService());
//        authQuestion
//                .nextQuestionHandler( new SelectTourTypeHandler(questionHandlerMap))
//                .nextQuestionHandler( new SelectTourHandler(questionHandlerMap,AppContextHolder.getTourService()))
//                .nextQuestionHandler( new AddTravelerHandler(questionHandlerMap))
//                .nextQuestionHandler( new BookingTourHandler(questionHandlerMap, AppContextHolder.getBookingService()))
//                .nextQuestionHandler( new DisplayTourTicketHandler(questionHandlerMap));;
//
//
//        authQuestion.run(new HashMap<>());

    }


}



