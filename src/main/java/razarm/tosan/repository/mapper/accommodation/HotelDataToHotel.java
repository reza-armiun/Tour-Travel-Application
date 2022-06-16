package razarm.tosan.repository.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.data.accommodation.HotelData;
import razarm.tosan.repository.domain.accommodation.Hotel;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;

import java.time.ZoneId;

@Component
public class HotelDataToHotel implements Mapper<HotelData, Hotel> {
    private final AccProviderDataToAccProvider accProviderDataToAccProvider;
    private final AddressDataToAddress addressDataToAddress;

    public HotelDataToHotel(AccProviderDataToAccProvider accProviderDataToAccProvider, AddressDataToAddress addressDataToAddress) {
        this.accProviderDataToAccProvider = accProviderDataToAccProvider;
        this.addressDataToAddress = addressDataToAddress;
    }

    @Override
    public Hotel convert(HotelData hotelData) {
    return Hotel.HotelBuilder.aHotel()
            .id(hotelData.getId())
            .name(hotelData.getName())
            .checkIn(hotelData.getCheckIn() != null ? hotelData.getCheckIn().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)) : null)
            .checkOut(hotelData.getCheckOut() != null ? hotelData.getCheckOut().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)) : null)
            .price(hotelData.getPrice())
            .type(hotelData.getType())
            .floor(hotelData.getFloor())
            .room(hotelData.getRoom())
            .accommodationProvider(hotelData.getAccommodationProvider() != null ? accProviderDataToAccProvider.convert(hotelData.getAccommodationProvider()) : null)
            .address(hotelData.getAddress() != null ? addressDataToAddress.convert(hotelData.getAddress()) : null)
            .createdAt(hotelData.getCreatedAt())
            .modifiedAt(hotelData.getModifiedAt())
            .createdBy(hotelData.getCreatedBy())
            .modifiedBy(hotelData.getModifiedBy())
            .build();
    }
}
