package razarm.tosan.controller.commandline;

import java.io.*;

public class AuthQuestionHandler extends QuestionHandler {

    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";



    public AuthQuestionHandler() { }

    private boolean login(String username, String password) {
        if(username.equals(USERNAME) && password.equals(PASSWORD)) return true; //TODO add AuthService
        return false;
    }



    @Override
    public void run(Object ...values) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))){
            String username = "";
            String password = "";
            while (true) {
                System.out.println("Enter Username:");
                username = reader.readLine();
                System.out.println("Enter Password:");
                password = reader.readLine();
                Thread.sleep(500);
                if(login(username, password )) {
                    if(next != null)
                        nextQuestion(); //TODO pass sessionID
                    return;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}




