package razarm.tosan.security.bruteforce;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.SignupRequest;
@Component
public class SignupExecutionImpl implements SignupExecution{

    @Override
    public void sayHello() {
        System.out.println("HELLO");
    }
}
