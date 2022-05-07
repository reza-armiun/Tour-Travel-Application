package razarm.tosan.repository.mapper.accommodation;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.accommodation.AccommodationType;
import razarm.tosan.repository.mapper.location.*;

public class AccommodationDataMapperFactory {
    private static final CountryDataToCountry countryDataToCountry = new CountryDataToCountry();
    private static final CountryToCountryData countryToCountryData = new CountryToCountryData();
    private static final CityDataToCity cityDataToCity = new CityDataToCity(countryDataToCountry);
    private static final CityToCityData cityToCityData = new CityToCityData(countryToCountryData);

    private static final AccProviderToAccProviderData accProviderToAccProviderData = new AccProviderToAccProviderData();
    private static final AccProviderDataToAccProvider accProviderDataToAccProvider = new AccProviderDataToAccProvider();
    private static final AddressToAddressData addressToAddressData = new AddressToAddressData(cityToCityData);
    private static final AddressDataToAddress addressDataToAddress = new AddressDataToAddress(cityDataToCity);
    private static final HotelToHotelData hotelToHotelData = new HotelToHotelData(accProviderToAccProviderData, addressToAddressData);
    private static final HotelDataToHotel hotelDataToHotel  = new HotelDataToHotel(accProviderDataToAccProvider, addressDataToAddress);

    private AccommodationDataMapperFactory(){}


    public static Mapper createAccommodationMapper(AccommodationType type) {
        switch (type) {
            case HOTEL:
                return hotelToHotelData;
            default:
                throw new IllegalArgumentException("invalid accommodation type");
        }
    }

    public static Mapper createAccommodationDataMapper(AccommodationType type) {
        switch (type) {
            case HOTEL:
                return hotelDataToHotel;
            default:
                throw new IllegalArgumentException("invalid accommodation type");
        }
    }
}
