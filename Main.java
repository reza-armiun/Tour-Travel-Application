package razarm.tosan;



import razarm.tosan.controller.commandline.*;
import razarm.tosan.exception.UserNotFoundException;

import javax.naming.directory.InvalidAttributeValueException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public class Main {






    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InvalidAttributeValueException, UserNotFoundException {

        MockDataInitializer.initialize();


        var authQuestion = new AuthQuestionHandler(AppContextHolder.getAuthService());
        authQuestion
                .nextQuestionHandler(SelectTourTypeHandler.NAME, new SelectTourTypeHandler())
                .nextQuestionHandler(SelectTourHandler.NAME, new SelectTourHandler(AppContextHolder.getTourService()))
                .nextQuestionHandler(AddTravelerHandler.NAME, new AddTravelerHandler())
                .nextQuestionHandler(BookingTourHandler.NAME, new BookingTourHandler(AppContextHolder.getBookingService()))
                .nextQuestionHandler(DisplayTourTicketHandler.NAME, new DisplayTourTicketHandler());
        ;

        authQuestion.run(new HashMap<>());
//
//        authQuestion
//                .nextQuestionHandler(new DisplayTourTicketHandler());
//
//
//        authQuestion.run();
        //////////////////////////////////////////////////////
//                .nextQuestionHandler(new BookingTourHandler());
//                .nextQuestionHandler(new SelectTourQuestionHandler())
//                .nextQuestionHandler(new TourBuilderQuestionHandler());



//
//        try {
//            FileOutputStream fileOut =
//                    new FileOutputStream("./employee.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(country);
//            out.close();
//            fileOut.close();
//            System.out.printf("Serialized data is saved in /tmp/employee.ser");
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
//        Country e = null;
//        try {
//            FileInputStream fileIn = new FileInputStream("./employee.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            e = (Country) in.readObject();
//            in.close();
//            fileIn.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//            return;
//        } catch (ClassNotFoundException c) {
//            System.out.println("City class not found");
//            c.printStackTrace();
//            return;
//        }
//
//        System.out.println("Deserialized City...");
//        System.out.println(e);

        // write your code here
    }


}




