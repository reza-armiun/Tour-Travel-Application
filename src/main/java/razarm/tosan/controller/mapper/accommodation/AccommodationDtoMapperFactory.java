package razarm.tosan.controller.mapper.accommodation;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.*;
import razarm.tosan.repository.domain.accommodation.AccommodationType;

@Component
public class AccommodationDtoMapperFactory {
    private static final CountryDtoToCountry countryDtoToCountry = new CountryDtoToCountry();
    private static final CountryToCountryDto countryToCountryDto = new CountryToCountryDto();

    private static final CityDtoToCity cityDtoToCity =  new CityDtoToCity(countryDtoToCountry);
    private static final CityToCityDto cityToCityDto = new CityToCityDto(countryToCountryDto);

    private static final AddressDtoToAddress addressDtoToAddress = new AddressDtoToAddress(cityDtoToCity);
    private static final AddressToAddressDto addressToAddressDto = new AddressToAddressDto(cityToCityDto);

    private static final AccProviderDtoToAccProvider accProviderDtoToAccProvider = new AccProviderDtoToAccProvider(addressDtoToAddress);
    private static final AccProviderToAccProviderDto accProviderToAccProviderDto =  new AccProviderToAccProviderDto(addressToAddressDto);

    private static final  HotelDtoToHotel hotelDtoToHotel = new HotelDtoToHotel(addressDtoToAddress, accProviderDtoToAccProvider);
    private static final HotelToHotelDto hotelToHotelDto = new HotelToHotelDto(addressToAddressDto, accProviderToAccProviderDto);

    private AccommodationDtoMapperFactory() {}

    public static Mapper createAccommodationMapper(AccommodationType type) {
        switch (type) {
            case HOTEL:
                return  hotelToHotelDto;
            default:
                throw new IllegalArgumentException("invalid accommodation type");

        }
    }

    public static Mapper createAccommodationDtoMapper(AccommodationType type) {
        switch (type) {
            case HOTEL:
                return hotelDtoToHotel;

            default:
                throw new IllegalArgumentException("invalid accommodation type");
        }

    }

}
