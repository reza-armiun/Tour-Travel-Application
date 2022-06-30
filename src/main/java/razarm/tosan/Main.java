package razarm.tosan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import razarm.tosan.exception.UserNotFoundException;

import javax.naming.directory.InvalidAttributeValueException;
import java.net.UnknownHostException;


@SpringBootApplication
@EnableConfigurationProperties
//@EnableAspectJAutoProxy()
@EnableScheduling()
public class Main {
    private static final Logger logger
            = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws InvalidAttributeValueException, UserNotFoundException, UnknownHostException {
        logger.info("Hello world info");
        logger.warn("Hello world warn");
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




