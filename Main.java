package razarm.tosan;



import razarm.tosan.controller.commandline.*;

import java.io.*;


public class Main {



    public static void main(String[] args) throws IOException {


        var authQuestion = new AuthQuestionHandler();

        authQuestion
                .nextQuestionHandler(new SelectTourQuestionHandler())
                .nextQuestionHandler(new TourBuilderQuestionHandler());


        authQuestion.run();







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




