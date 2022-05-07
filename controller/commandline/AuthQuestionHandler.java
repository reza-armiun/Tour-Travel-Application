package razarm.tosan.controller.commandline;

import razarm.tosan.controller.commandline.question.QuestionFactory;
import razarm.tosan.controller.dto.auth.LoginRequest;
import razarm.tosan.exception.InvalidCredentialException;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.service.AuthService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AuthQuestionHandler extends QuestionHandler {
    public static final String NAME = "AUTH";


    private final AuthService authService;


    public AuthQuestionHandler(AuthService authService) {
        this.authService = authService;
    }

    private boolean login(String username, String password) {
        var request =
                LoginRequest.LoginRequestBuilder.aLoginRequest()
                        .username(username)
                        .password(password)
                        .build();
       try{
           var sessionId = authService.login(request);
           return true;
       }catch (InvalidCredentialException | UserNotFoundException e) {
           return false;
       }
    }



    @Override
    public void run(Map<String, Object> values) {
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
                    QuestionFactory.showSuccessMsg("Successfully Logged In...");
                    if(next != null){
                        if(values == null) values = new HashMap<>();
                        values.put("username", username);
                        nextQuestion(values); //TODO pass sessionID
                    }
                    return;
                }
                System.err.println("Invalid Credential...");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}




