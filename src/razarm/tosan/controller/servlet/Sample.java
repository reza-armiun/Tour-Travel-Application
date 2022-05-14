package razarm.tosan.controller.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class Sample extends HttpServlet {
    Logger logger = Logger.getLogger(Sample.class.getName());




    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(request, response);

//        PrintWriter var3 = response.getWriter();
//        var3.println("<html>");
//        var3.println("<head>");
//        var3.println("</head>");
//        var3.println("<body>");
//        var3.println("<h3>Hey!</h3>");
//        var3.println("</body>");
//        var3.println("</html>");
    }
}