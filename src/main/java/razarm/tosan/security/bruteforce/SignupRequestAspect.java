package razarm.tosan.security.bruteforce;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.SignupRequest;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class SignupRequestAspect {
    private final HttpServletRequest httpServletRequest;
    private final LoginAttemptService loginAttemptService;


    private String getClientIp() {
        final String xfHeader = httpServletRequest.getHeader("X-Forwarded-For");
        if(xfHeader == null) {
            return httpServletRequest.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

    @Around("execution(* razarm.tosan.security.controller.AuthController.signup(..)) && args(signupRequest) ")
    public Object beforeSendConfirmationToken(ProceedingJoinPoint pjp, SignupRequest signupRequest) throws Throwable {
        final String ip = getClientIp();
        if(loginAttemptService.isBlocked(ip)) {
            throw new IllegalStateException("Your ip is temporarily blocked, Please try later");
        }
        else {
            return pjp.proceed();
        }
    }
}
