package razarm.tosan.controller.servlet;

import razarm.tosan.AppContextHolder;
import razarm.tosan.service.tour.TourService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Home extends HttpServlet {
    private TourService tourService;

    @Override
    public void init() throws ServletException {
        super.init();
        tourService = AppContextHolder.getTourService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var tourList = tourService.findAll();

        req.setAttribute("tourList" , tourList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req, resp);
    }
}
