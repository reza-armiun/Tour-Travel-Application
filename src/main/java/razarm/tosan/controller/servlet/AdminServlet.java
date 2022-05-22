package razarm.tosan.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import razarm.tosan.AppContextHolder;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.service.tour.TourService;
import razarm.tosan.utility.AppJsonMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class AdminServlet extends HttpServlet {
    private TourService tourService;


    @Override
    public void init() throws ServletException {
        super.init();
        this.tourService = AppContextHolder.getTourService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("pageToShow", "admin/json-tours.jsp");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/layout.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestData = request.getReader().lines().collect(Collectors.joining());

        try{
            ObjectMapper objectMapper = AppJsonMapper.getAppJsonMapper();
            TourDto tour = objectMapper.readValue(requestData, TourDto.class);
            this.tourService.create(tour);
        }catch (Exception e) {
            e.printStackTrace();
        }
;
    }
}
