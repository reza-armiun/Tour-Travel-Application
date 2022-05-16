package razarm.tosan.controller.mapper.tour;

import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.user.UserDtoToUser;
import razarm.tosan.repository.domain.Booking;

import java.util.stream.Collectors;

public class BookingDtoToBooking implements Mapper<BookingDto, Booking> {
    private final TravelerDtoToTraveler travelerDtoToTraveler;
    private final TourDtoToTour tourDtoTour;
    private final UserDtoToUser userDtoToUser;

    public BookingDtoToBooking(TravelerDtoToTraveler travelerDtoToTraveler, TourDtoToTour tourDtoTour, UserDtoToUser userDtoToUser) {
        this.travelerDtoToTraveler = travelerDtoToTraveler;
        this.tourDtoTour = tourDtoTour;
        this.userDtoToUser = userDtoToUser;
    }

    @Override
    public Booking convert(BookingDto bookingDto) {
    return Booking.BookingBuilder.aBooking()
            .id(bookingDto.getId())
            .date(bookingDto.getDate().toInstant())
            .description(bookingDto.getDescription())
            .user(bookingDto.getUser() != null ?userDtoToUser.convert(bookingDto.getUser()) : null)
            .travelers(bookingDto.getTravelers().stream().map(travelerDtoToTraveler::convert).collect(Collectors.toUnmodifiableSet()))
            .tour(bookingDto.getTour() != null ? tourDtoTour.convert(bookingDto.getTour()) : null)
            .createdAt(bookingDto.getCreatedAt().toInstant())
            .modifiedAt(bookingDto.getModifiedAt().toInstant())
            .createdBy(bookingDto.getCreatedBy())
            .modifiedBy(bookingDto.getModifiedBy())
            .build();
    }
}
