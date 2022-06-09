package razarm.tosan.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.mapper.tour.BookingDtoToBooking;
import razarm.tosan.controller.mapper.tour.BookingToBookingDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.BookingRepository;
import razarm.tosan.repository.TourRateRepository;
import razarm.tosan.repository.TourRepository;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.repository.domain.tour.TourRate;
import razarm.tosan.service.tour.BookingService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final TourRepository tourRepository;
    private final TourRateRepository tourRateRepository;
    private final BookingDtoToBooking bookingDtoToBooking;
    private final BookingToBookingDto bookingToBookingDto;




    @Override
    public void bookingNewTour(String username, BookingDto bookingDto) throws UserNotFoundException {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new UserNotFoundException("user not found");

        var booking = bookingDtoToBooking.convert(bookingDto);
        var newTour = booking.getTour();
        var savedTour = tourRepository.save(newTour);


        var newBookings = new HashSet<>(user.getBookings());
        newBookings.add(booking.cloneWithTour(savedTour));
        user.setBookings(newBookings);
        userRepository.update(user);

//        var savedBooking = bookingRepository.save(booking.cloneWithUser(user));
//        return this.bookingToBookingDto.convert(savedBooking);
    }

    @Override
    public BookingDto bookingTour(String username, String tourId, BookingDto bookingDto) throws UserNotFoundException {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new UserNotFoundException("user not found");

        var tour = tourRepository.findById(tourId);
        if(tour == null ) throw new IllegalStateException("tour not found");

        var booking = bookingDtoToBooking.convert(bookingDto);


        var newBookings = new HashSet<>(user.getBookings());
        newBookings.add(booking.cloneWithTour(tour));
        user.setBookings(newBookings);
        userRepository.update(user);


        var editedUser =  userRepository.findByUsername(username);
        var savedBooking = editedUser.getBookings().stream().sorted((o1, o2) -> o1.getDate().isBefore(o2.getDate()) ? 1 : -1).findFirst();
        return  this.bookingToBookingDto.convert(savedBooking.get());

//        var savedBooking = bookingRepository.save(booking.cloneWithUser(user).cloneWithTour(tour));

//        return this.bookingToBookingDto.convert(savedBooking);
    }



    @Override
    public void editBooking(String username, BookingDto bookingDto) throws UserNotFoundException {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new IllegalStateException("user not found");

        var booking = bookingDtoToBooking.convert(bookingDto);

        var newBookings = new HashSet<>(user.getBookings());
        newBookings.removeIf(bk -> bk.getId().equals(booking.getId()));
        newBookings.add(booking);
        user.setBookings(newBookings);
        userRepository.update(user);
//        bookingRepository.update(booking.cloneWithUser(user));
    }

    @Override
    public void removeBooking(String username, String bookingId) {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new IllegalStateException("user not found");

        var newBookings = new HashSet<>(user.getBookings());
        newBookings.removeIf(bk -> bk.getId().equals(bookingId));
        user.setBookings(newBookings);
        userRepository.update(user);
//        bookingRepository.deleteById(bookingId);
    }

    @Override
    public List<BookingDto> findUserBookings(String username) {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new IllegalStateException("user not found");

        return user.getBookings().stream()
                .map(this.bookingToBookingDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<BookingDto> findAllBooking() {
        return this.userRepository.findAll().stream()
                .map(User::getBookings)
                .flatMap(Collection::stream)
                .map(this.bookingToBookingDto::convert)
                .collect(Collectors.toUnmodifiableList());
//        return bookingRepository.findAll().stream()
//                .map(bookingToBookingDto::convert)
//                .map(
//                        bookingDto -> {
//                            TourDto tour =
//                                    bookingDto
//                                            .getTour()
//                                            .cloneWithRating(
//                                                    getTourRating(bookingDto.getTour().getId()));
//                            return bookingDto.cloneWithTour(tour);
//                        })
//                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public BookingDto findById(String username ,String id) {
        var user = this.userRepository.findByUsername(username);
        var booking = user.getBookings().stream()
                .filter(bk -> bk.getId().equals(id))
                .findFirst().orElse(null);



        if(booking != null) return this.bookingToBookingDto
                .convert(booking.cloneWithTour(this.tourRepository.findById(booking.getTour().getId())));
        else return null;

//        BookingDto bookingDto = bookingToBookingDto.convert(bookingRepository.findById(id));
//        TourDto tour =
//                bookingDto.getTour().cloneWithRating(getTourRating(bookingDto.getTour().getId()));
//        return bookingDto.cloneWithTour(tour);
    }

    private Float getTourRating(String tourId) {
        var rateList = tourRateRepository.getAllTourRates(tourId);
        var size = rateList.size();
        var sum = rateList.stream().map(TourRate::getRating).reduce(0 , Integer::sum);
        return   (float) sum/ (float) size;
    }
}
