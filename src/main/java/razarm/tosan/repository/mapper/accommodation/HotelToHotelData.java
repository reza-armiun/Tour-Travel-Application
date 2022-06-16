package razarm.tosan.repository.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.accommodation.HotelData;
import razarm.tosan.repository.domain.accommodation.Hotel;
import razarm.tosan.repository.mapper.location.AddressToAddressData;
@Component
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
                .checkIn(hotel.getCheckIn() != null ? hotel.getCheckIn().toInstant() : null)
                .checkOut(hotel.getCheckOut() != null ? hotel.getCheckOut().toInstant() : null)
                .address(
                        hotel.getAddress() != null
                                ? this.addressToAddressData.convert(hotel.getAddress())
                                : null)
                .accommodationProvider(
                        hotel.getAccommodationProvider() != null ? this.accProviderToAccProviderData.convert(hotel.getAccommodationProvider()) : null)
                .type(hotel.getType())
                .createdAt(hotel.getCreatedAt())
                .modifiedAt(hotel.getModifiedAt())
                .createdBy(hotel.getCreatedBy())
                .modifiedBy(hotel.getModifiedBy())
                .build();
    }
}
