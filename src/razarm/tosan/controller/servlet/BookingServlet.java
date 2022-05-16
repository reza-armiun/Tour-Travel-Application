package razarm.tosan.controller.servlet;

import razarm.tosan.AppContextHolder;
import razarm.tosan.service.tour.BookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookingServlet extends HttpServlet {
    private BookingService bookingService;

    @Override
    public void init() throws ServletException {
        super.init();
        bookingService = AppContextHolder.getBookingService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getPathInfo().replace("/", "").trim();
        var booking = bookingService.findById(bookId);


        var session = req.getSession();
        synchronized (session) {
            session.setAttribute("booking", booking);
        }

        req.setAttribute("pageToShow", "tour/booking-success.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/layout.jsp");
        dispatcher.forward(req, resp);
    }
}
