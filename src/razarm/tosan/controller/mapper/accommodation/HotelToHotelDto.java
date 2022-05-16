package razarm.tosan.controller.mapper.accommodation;

import razarm.tosan.controller.dto.accommodation.HotelDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.accommodation.Hotel;

import java.time.ZoneId;

public class HotelToHotelDto implements Mapper<Hotel, HotelDto> {
    private final AddressToAddressDto addressToAddressDto;
    private final AccProviderToAccProviderDto accProviderToAccProviderDto;

    public HotelToHotelDto(AddressToAddressDto addressToAddressDto, AccProviderToAccProviderDto accProviderToAccProviderDto) {
        this.addressToAddressDto = addressToAddressDto;
        this.accProviderToAccProviderDto = accProviderToAccProviderDto;
    }

    @Override
    public HotelDto convert(Hotel hotel) {
        return HotelDto.HotelDtoBuilder.aHotelDto()
                .id(hotel.getId())
                .name(hotel.getName())
                .price(hotel.getPrice())
                .time(hotel.getTime())
                .addressDto(addressToAddressDto.convert(hotel.getAddress()))
                .accommodationProvider(accProviderToAccProviderDto.convert(hotel.getAccommodationProvider()))
                .floor(hotel.getFloor())
                .room(hotel.getRoom())
                .type(hotel.getType())
                .createdAt(hotel.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(hotel.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(hotel.getCreatedBy())
                .modifiedBy(hotel.getModifiedBy())
                .build();
     }
}
