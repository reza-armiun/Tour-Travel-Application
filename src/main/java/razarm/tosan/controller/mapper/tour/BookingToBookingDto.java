package razarm.tosan.controller.mapper.tour;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.user.UserToUserDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.Booking;

import java.time.ZoneId;
import java.util.stream.Collectors;
@Component
public class BookingToBookingDto implements Mapper<Booking, BookingDto> {
    private final TravelerToTravelerDto travelerToTravelerDto;
    private final TourToTourDto tourToTourDto;
    private final UserToUserDto userToUserDto;
    public BookingToBookingDto(TravelerToTravelerDto travelerToTravelerDto, TourToTourDto tourToTourDto, UserToUserDto userToUserDto) {
        this.travelerToTravelerDto = travelerToTravelerDto;
        this.tourToTourDto = tourToTourDto;
        this.userToUserDto = userToUserDto;
    }

    @Override
    public BookingDto convert(Booking booking) {
        return BookingDto.BookingDtoBuilder.aBookingDto()
                .id(booking.getId())
                .date(booking.getDate().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .description(booking.getDescription())
                .user(booking.getUser() != null ? userToUserDto.convert(booking.getUser()): null)
                .travelers(booking.getTravelers().stream().map(travelerToTravelerDto::convert).collect(Collectors.toUnmodifiableSet()))
                .tour(booking.getTour() != null ? tourToTourDto.convert(booking.getTour()) : null)
                .createdAt(booking.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(booking.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(booking.getCreatedBy())
                .modifiedBy(booking.getModifiedBy())
                .build();
    }
}
