package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.HotelData;
import razarm.tosan.repository.domain.accommodation.Hotel;
import razarm.tosan.repository.mapper.location.AddressToAddressData;

public class HotelToHotelData implements Mapper<Hotel, HotelData> {
    private final AccProviderToAccProviderData accProviderToAccProviderData;
    private final AddressToAddressData addressToAddressData;

    public HotelToHotelData(AccProviderToAccProviderData accProviderToAccProviderData, AddressToAddressData addressToAddressData) {
        this.accProviderToAccProviderData = accProviderToAccProviderData;
        this.addressToAddressData = addressToAddressData;
    }

    @Override
    public HotelData convert(Hotel hotel) {
    return HotelData.HotelDataBuilder.aHotelData()
            .id(hotel.getId())
            .name(hotel.getName())
            .floor(hotel.getFloor())
            .room(hotel.getRoom())
            .price(hotel.getPrice())
            .time(hotel.getTime())
            .address(this.addressToAddressData.convert(hotel.getAddress()))
            .accommodationProvider(this.accProviderToAccProviderData.convert(hotel.getAccommodationProvider()))
            .type(hotel.getType())
            .createdAt(hotel.getCreatedAt())
            .modifiedAt(hotel.getModifiedAt())
            .createdBy(hotel.getCreatedBy())
            .modifiedBy(hotel.getModifiedBy())
            .build();
    }
}
