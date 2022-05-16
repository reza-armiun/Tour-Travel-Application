package razarm.tosan;



import razarm.tosan.controller.commandline.*;
import razarm.tosan.exception.UserNotFoundException;

import javax.naming.directory.InvalidAttributeValueException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.HashMap;
import java.util.Map;


public class Main {



    public static void main(String[] args) throws InvalidAttributeValueException, UserNotFoundException {

        MockDataInitializer.initialize();
//
        Map<String, QuestionHandler> questionHandlerMap = new HashMap<>();
        var authQuestion = new AuthQuestionHandler(questionHandlerMap, AppContextHolder.getAuthService());
        authQuestion
                .nextQuestionHandler( new SelectTourTypeHandler(questionHandlerMap))
                .nextQuestionHandler( new SelectTourHandler(questionHandlerMap,AppContextHolder.getTourService()))
                .nextQuestionHandler( new AddTravelerHandler(questionHandlerMap))
                .nextQuestionHandler( new BookingTourHandler(questionHandlerMap, AppContextHolder.getBookingService()))
                .nextQuestionHandler( new DisplayTourTicketHandler(questionHandlerMap));;


        authQuestion.run(new HashMap<>());



//        var tourService = AppContextHolder.getTourService();
//        var tour = tourService.findById("69");
//        System.out.println(tour);
//        var tourRateRepository = AppContextHolder.getTourRateRepository();
//        System.out.println(tourService.findAll());
    }


}




