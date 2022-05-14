package razarm.tosan.repository.mapper;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.BookingData;
import razarm.tosan.repository.domain.Booking;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.domain.tour.Tour;

import java.util.stream.Collectors;

public class BookingDataToBooking implements Mapper<BookingData, Booking> {
    private final TravelerDataToTraveler travelerDataToTraveler;

    public BookingDataToBooking(TravelerDataToTraveler travelerDataToTraveler) {
        this.travelerDataToTraveler = travelerDataToTraveler;
    }

    @Override
    public Booking convert(BookingData bookingData) {
        return Booking.BookingBuilder.aBooking()
                .id(bookingData.getId())
                .date(bookingData.getDate())
                .description(bookingData.getDescription())
                .user(bookingData.getUserId() !=null ? PremiumUser.PremiumUserBuilder.aPremiumUser().id(bookingData.getUserId()).build() : null)
                .tour(Tour.TourBuilder.aTour().id(bookingData.getTourId()).build())
                .travelers(bookingData.getTravelers().stream().map(travelerDataToTraveler::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(bookingData.getCreatedAt())
                .modifiedAt(bookingData.getModifiedAt())
                .createdBy(bookingData.getCreatedBy())
                .modifiedBy(bookingData.getModifiedBy())
                .build();
    }
}
