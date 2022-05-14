package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.controller.mapper.tour.BookingDtoToBooking;
import razarm.tosan.controller.mapper.tour.BookingToBookingDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.BookingRepository;
import razarm.tosan.repository.TourRepository;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.service.tour.BookingService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final TourRepository tourRepository;
    private final BookingDtoToBooking bookingDtoToBooking;
    private final BookingToBookingDto bookingToBookingDto;

    public BookingServiceImpl(UserRepository userRepository, BookingRepository bookingRepository, TourRepository tourRepository, BookingDtoToBooking bookingDtoToBooking, BookingToBookingDto bookingToBookingDto) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.tourRepository = tourRepository;
        this.bookingDtoToBooking = bookingDtoToBooking;
        this.bookingToBookingDto = bookingToBookingDto;
    }


    @Override
    public BookingDto bookingNewTour(String username, BookingDto bookingDto) throws UserNotFoundException {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new UserNotFoundException("user not found");

        var booking = bookingDtoToBooking.convert(bookingDto);

        var savedBooking = bookingRepository.save(booking.cloneWithUser(user));
        return this.bookingToBookingDto.convert(savedBooking);
    }

    @Override
    public BookingDto bookingTour(String username, String tourId, BookingDto bookingDto) throws UserNotFoundException {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new UserNotFoundException("user not found");

        var tour = tourRepository.findById(tourId);
        if(tour == null ) throw new IllegalStateException("tour not found");

        var booking = bookingDtoToBooking.convert(bookingDto);
        var savedBooking = bookingRepository.save(booking.cloneWithUser(user).cloneWithTour(tour));

        return this.bookingToBookingDto.convert(savedBooking);
    }

    @Override
    public void editBooking(String username, BookingDto bookingDto) throws UserNotFoundException {
        var user =  userRepository.findByUsername(username);
        if(user == null) throw new IllegalStateException("user not found");

        var booking = bookingDtoToBooking.convert(bookingDto);
        bookingRepository.update(booking.cloneWithUser(user));
    }

    @Override
    public void removeBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public List<BookingDto> findAllBooking() {
        return bookingRepository.findAll().stream()
            .map(bookingToBookingDto::convert)
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public BookingDto findById(String id) {
        return bookingToBookingDto.convert(bookingRepository.findById(id));
    }
}
