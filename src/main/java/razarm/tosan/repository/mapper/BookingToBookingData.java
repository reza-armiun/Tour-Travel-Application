package razarm.tosan.repository.mapper;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.tour.BookingData;
import razarm.tosan.repository.domain.Booking;

import java.util.stream.Collectors;

@Component
public class BookingToBookingData implements Mapper<Booking, BookingData> {
    private final TravelerToTravelerData travelerToTravelerData;

    public BookingToBookingData(TravelerToTravelerData travelerToTravelerData) {
        this.travelerToTravelerData = travelerToTravelerData;
    }

    @Override
    public BookingData convert(Booking booking) {
    return BookingData.BookingDataBuilder.aBookingData()
            .id(booking.getId())
            .date(booking.getDate())
            .description(booking.getDescription())
            .travelers(booking.getTravelers().stream().map(travelerToTravelerData::convert).collect(Collectors.toUnmodifiableSet()))
            .tourId(booking.getTour().getId())
            .createdAt(booking.getCreatedAt())
            .modifiedAt(booking.getModifiedAt())
            .createdBy(booking.getCreatedBy())
            .modifiedBy(booking.getModifiedBy())
            .build();
    }
}
