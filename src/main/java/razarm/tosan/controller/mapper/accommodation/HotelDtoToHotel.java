package razarm.tosan.controller.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.accommodation.HotelDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.repository.domain.accommodation.Hotel;
@Component
public class HotelDtoToHotel implements Mapper<HotelDto , Hotel> {
    private final AddressDtoToAddress addressDtoToAddress;
    private final AccProviderDtoToAccProvider accProviderDtoToAccProvider;

    public HotelDtoToHotel(AddressDtoToAddress addressDtoToAddress, AccProviderDtoToAccProvider accProviderDtoToAccProvider) {
        this.addressDtoToAddress = addressDtoToAddress;
        this.accProviderDtoToAccProvider = accProviderDtoToAccProvider;
    }

    @Override
    public Hotel convert(HotelDto hotelDto) {
        return Hotel.HotelBuilder.aHotel()
                .id(hotelDto.getId())
                .name(hotelDto.getName())
                .type(hotelDto.getType())
                .address(hotelDto.getAddress() != null  ? addressDtoToAddress.convert(hotelDto.getAddress()) : null)
                .price(hotelDto.getPrice())
                .time(hotelDto.getTime())
                .accommodationProvider(accProviderDtoToAccProvider.convert(hotelDto.getAccommodationProvider()))
                .floor(hotelDto.getFloor())
                .room(hotelDto.getRoom())
                .createdAt(hotelDto.getCreatedAt().toInstant())
                .modifiedAt(hotelDto.getModifiedAt().toInstant())
                .createdBy(hotelDto.getCreatedBy())
                .modifiedBy(hotelDto.getModifiedBy())
                .build();
    }
}
