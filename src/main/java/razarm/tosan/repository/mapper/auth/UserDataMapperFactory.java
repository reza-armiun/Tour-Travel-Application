package razarm.tosan.repository.mapper.auth;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.domain.auth.PremiumUser;

@Component
@AllArgsConstructor
@Slf4j
public class UserDataMapperFactory {
    private final PremiumUserToPremiumUserData premiumUserToPremiumUserData;
    private final PremiumUserDataToPremiumUser premiumUserDataToPremiumUser;
//    private static final InterestDataToInterest interestDataToInterest = new InterestDataToInterest();
//    private static final InterestToInterestData interestToInterestData = new InterestToInterestData();
//    private static final CountryDataToCountry countryDataToCountry = new CountryDataToCountry();
//    private static final CountryToCountryData countryToCountryData = new CountryToCountryData();
//    private static final CityDataToCity cityDataToCity = new CityDataToCity(countryDataToCountry);
//    private static final CityToCityData cityToCityData = new CityToCityData(countryToCountryData);
//
//    private static final AddressToAddressData addressToAddressData = new AddressToAddressData(cityToCityData);
//    private static final AddressDataToAddress addressDataToAddress = new AddressDataToAddress(cityDataToCity);
//
//    private static final PremiumUserToPremiumUserData premiumUserToPremiumUserData = new PremiumUserToPremiumUserData(interestToInterestData, addressToAddressData, );
//    private static final PremiumUserDataToPremiumUser premiumUserDataToPremiumUser = new PremiumUserDataToPremiumUser(interestDataToInterest, addressDataToAddress);

//    private UserDataMapperFactory() {}



    public  <T> Mapper  createUserMapper(Class<T> c) {
        if(c == PremiumUser.class)  return premiumUserToPremiumUserData;

        throw new IllegalArgumentException("invalid user type");
    }


    public  <T> Mapper createUserDataMapper (Class<T> c) {
        if(c == PremiumUserData.class) return premiumUserDataToPremiumUser;

        throw new IllegalArgumentException("invalid user type");
    }
}
