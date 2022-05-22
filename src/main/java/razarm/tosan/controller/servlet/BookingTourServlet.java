package razarm.tosan.controller.servlet;

import razarm.tosan.AppContextHolder;
import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.controller.dto.tour.TravelerDto;
import razarm.tosan.repository.domain.auth.UserDetails;
import razarm.tosan.service.tour.BookingService;
import razarm.tosan.service.tour.TourService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Set;

public class BookingTourServlet extends HttpServlet {

    private TourService tourService ;
    private BookingService bookingService;

    @Override
    public void init() throws ServletException {
        super.init();
        tourService = AppContextHolder.getTourService();
        this.bookingService = AppContextHolder.getBookingService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tourId = req.getPathInfo().replace("/", "").trim();
        var tour = tourService.findById(tourId);
        req.getSession().setAttribute("tour", tour);
        req.setAttribute("pageToShow", "tour/booking-form.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/layout.jsp");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tourId = req.getPathInfo().replace("/", "").trim();
        var firstName = req.getParameter("firstName");
        var lastName = req.getParameter("lastName");
        var email = req.getParameter("email");
        var phone = req.getParameter("phone");
        var nationalId = req.getParameter("nationalId");
        var description = req.getParameter("description");

        var traveler = TravelerDto.TravelerDtoBuilder.aTravelerDto().name(firstName + " " + lastName)
                                                     .email(email)
                                                     .phone(phone)
                                                     .nationalId(Long.valueOf(nationalId))
                                                     .build();

        UserDetails user = (UserDetails) req.getSession().getAttribute("principal");

            BookingDto bookingDto =
                    BookingDto.BookingDtoBuilder.aBookingDto()
                            .travelers(Set.of(traveler))
                            .date(ZonedDateTime.now())
                            .description(description)
                            .build();
            var savedBooking = bookingService.bookingTour(user.getUsername(), tourId, bookingDto);

            resp.sendRedirect(req.getContextPath() + "/booking/" + savedBooking.getId());
    }
}
