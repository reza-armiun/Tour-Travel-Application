package razarm.tosan.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Secure extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var dispatcher = req.getRequestDispatcher("/jsp/secure.jsp");
        dispatcher.forward(req, resp);
    }
}
