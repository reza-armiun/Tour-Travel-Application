package razarm.tosan.controller.servlet;

import razarm.tosan.AppContextHolder;
import razarm.tosan.MockDataInitializer;
import razarm.tosan.controller.dto.auth.LoginRequest;
import razarm.tosan.exception.InvalidCredentialException;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.service.AuthService;

import javax.naming.directory.InvalidAttributeValueException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

public class Login extends HttpServlet {
    Logger logger = Logger.getLogger(Login.class.getName());

    private  AuthService authService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.authService = AppContextHolder.getAuthService();
    }

    public Login() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var dispatcher = req.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        var request = LoginRequest.LoginRequestBuilder.aLoginRequest().username(username).password(password).build();
        RequestDispatcher requestDispatcher ;
        try{
            var user = authService.login(request);
            logger.info(user.toString());
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("principal", user);
            }

            resp.setHeader("Set-Cookie", "JSESSIONID=" + req.changeSessionId() +"; HttpOnly=true; SameSite=strict"); // adds new session
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }catch (InvalidCredentialException | UserNotFoundException e) {
            e.printStackTrace();
            requestDispatcher = req.getRequestDispatcher("/jsp/login-failed.jsp");
        }
        requestDispatcher.forward(req, resp);
    }
}
