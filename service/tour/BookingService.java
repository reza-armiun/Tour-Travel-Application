package razarm.tosan.service.tour;

import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.controller.dto.tour.BookingRequest;
import razarm.tosan.controller.dto.tour.TourDto;

import java.util.List;

public interface BookingService {

   TourDto bookingTour(BookingRequest request);
   void editBooking(String id ,BookingRequest bookingRequest);
   void removeBooking(String bookingId);
   List<BookingDto> findAllBooking();
   BookingDto findById(String id);


}
