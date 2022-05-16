package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.HotelData;
import razarm.tosan.repository.domain.accommodation.Hotel;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;

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
            .time(hotelData.getTime())
            .price(hotelData.getPrice())
            .type(hotelData.getType())
            .floor(hotelData.getFloor())
            .room(hotelData.getRoom())
            .accommodationProvider(accProviderDataToAccProvider.convert(hotelData.getAccommodationProvider()))
            .address(addressDataToAddress.convert(hotelData.getAddress()))
            .createdAt(hotelData.getCreatedAt())
            .modifiedAt(hotelData.getModifiedAt())
            .createdBy(hotelData.getCreatedBy())
            .modifiedBy(hotelData.getModifiedBy())
            .build();
    }
}
