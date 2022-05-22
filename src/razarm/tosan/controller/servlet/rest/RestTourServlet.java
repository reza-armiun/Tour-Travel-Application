package razarm.tosan.controller.servlet.rest;

import razarm.tosan.AppContextHolder;
import razarm.tosan.service.tour.TourService;
import razarm.tosan.utility.AppJsonMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RestTourServlet extends HttpServlet {
    private TourService tourService;
    @Override
    public void init() throws ServletException {
        super.init();
        this.tourService = AppContextHolder.getTourService();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var tours = this.tourService.findAll();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        AppJsonMapper.getAppJsonMapper().writeValue(out, tours);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
