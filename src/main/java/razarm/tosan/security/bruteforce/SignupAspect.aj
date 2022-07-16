//package razarm.tosan.security.bruteforce;
//
//import lombok.AllArgsConstructor;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import razarm.tosan.controller.dto.auth.SignupRequest;
//import razarm.tosan.security.controller.AuthController;
//
//import javax.servlet.http.HttpServletRequest;
//
//
//@Component
//@AllArgsConstructor
//@Aspect
//public aspect SignupAspect {
//
////    @Autowired
////    private HttpServletRequest httpServletRequest;
////    @Autowired
////    private  LoginAttemptService loginAttemptService;
////
////    private String getClientIp() {
////        final String xfHeader = httpServletRequest.getHeader("X-Forwarded-For");
////        if (xfHeader == null) {
////            return httpServletRequest.getRemoteAddr();
////        }
////        return xfHeader.split(",")[0];
////    }
//
//    pointcut callSignup(SignupRequest signupRequest, AuthController authController) :
//            call(*  razarm.tosan.security.controller.AuthController.signup(SignupRequest)) && args(signupRequest) && target(authController);
//
//
//
//
//    Object around(SignupRequest signupRequest, AuthController authController) : callSignup(signupRequest, authController) {
////        final  String ip = getClientIp();
////        if(loginAttemptService.isBlocked(ip)) {
////            throw new IllegalStateException("your ip is temporarily blocked, Please try later");
////        }
//        System.out.printf("HELLO WORLD!!");
//         return proceed(signupRequest, authController);
//    }
//
//}