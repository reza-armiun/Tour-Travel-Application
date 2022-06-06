package razarm.tosan.service.tour;

import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.exception.UserNotFoundException;

import java.util.List;

public interface BookingService {

//   BookingDto bookingNewTour(String username, BookingDto bookingDto) throws UserNotFoundException;
   void bookingNewTour(String username, BookingDto bookingDto) throws UserNotFoundException;
   void bookingTour(String username, String tourId , BookingDto bookingDto) throws UserNotFoundException;

   void editBooking(String username, BookingDto bookingDto) throws UserNotFoundException;
   void removeBooking(String username, String bookingId);
//   void removeBooking(String bookingId);
   List<BookingDto> findUserBookings(String username);
   List<BookingDto> findAllBooking();
   BookingDto findById(String username, String id);




}
