package razarm.tosan.repository.inMemoryImpl.tour;

import org.springframework.stereotype.Repository;
import razarm.tosan.repository.BookingRepository;
import razarm.tosan.repository.TourRepository;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.data.tour.BookingData;
import razarm.tosan.repository.domain.Booking;
import razarm.tosan.repository.mapper.BookingDataToBooking;
import razarm.tosan.repository.mapper.BookingToBookingData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
    private Map<String, BookingData> bookingDataMap= new HashMap<>();

    private final BookingToBookingData bookingToBookingData;
    private final BookingDataToBooking bookingDataToBooking;
    private final TourRepository tourRepository;
    private final UserRepository userRepository;

    public BookingRepositoryImpl(BookingToBookingData bookingToBookingData, BookingDataToBooking bookingDataToBooking, TourRepository tourRepository, UserRepository userRepository) {
        this.bookingToBookingData = bookingToBookingData;
        this.bookingDataToBooking = bookingDataToBooking;
        this.tourRepository = tourRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Booking save(Booking booking) {
        var tour = booking.getTour();
//        if(tour.getTourType().equals(TourType.CUSTOM) && tour.getId() == null) {


        if(tour.getId() == null) {
            var newCustomTour = tourRepository.save(tour);
            booking = booking.cloneWithTour(newCustomTour);
        }else {
            var availableTour = tourRepository.findById(tour.getId());
            booking = booking.cloneWithTour(availableTour);
        }
//        else if(tour.getId() == null) throw new IllegalArgumentException("null tour id");

        var bookingData = bookingToBookingData.convert(booking);
        bookingDataMap.put(bookingData.getId(), bookingData);

        return booking.cloneWithId(bookingData.getId());
    }



    @Override
    public void update(Booking booking) {
        var bookingData = bookingToBookingData.convert(booking);
        bookingDataMap.put(bookingData.getId(), bookingData);


    }

    @Override
    public void deleteById(String s) {
        bookingDataMap.remove(s);
    }

    @Override
    public Booking findById(String s) {
        final var bookingData = bookingDataMap.get(s);
        var user = userRepository.findById(bookingData.getUserId());
        var tour = tourRepository.findById(bookingData.getTourId());
        var booking =  bookingDataToBooking.convert(bookingData);

        return booking.cloneWithUser(user).cloneWithTour(tour);
    }

    @Override
    public List<Booking> findAll() {
        return bookingDataMap.values().stream()
                .map(bookingDataToBooking::convert)
                .map(
                        booking -> {
                            var user = userRepository.findById(booking.getUser().getId());
                            var tour = tourRepository.findById(booking.getTour().getId());
                            return booking.cloneWithUser(user).cloneWithTour(tour);
                        })
                .collect(Collectors.toUnmodifiableList());
    }
}
