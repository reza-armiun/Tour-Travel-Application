package razarm.tosan.controller.mapper.user;

import razarm.tosan.controller.dto.auth.PremiumUserDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.*;
import razarm.tosan.repository.domain.auth.PremiumUser;

public class UserDtoMapperFactory {
    private static final CountryDtoToCountry countryDtoToCountry = new CountryDtoToCountry();
    private static final CountryToCountryDto countryToCountryDto = new CountryToCountryDto();

    private static final CityDtoToCity cityDtoToCity =  new CityDtoToCity(countryDtoToCountry);
    private static final CityToCityDto cityToCityDto = new CityToCityDto(countryToCountryDto);

    private static final AddressDtoToAddress addressDtoToAddress = new AddressDtoToAddress(cityDtoToCity);
    private static final AddressToAddressDto addressToAddressDto = new AddressToAddressDto(cityToCityDto);

    private static final InterestToInterestDto  interestToInterestDto =  new InterestToInterestDto();
    private static final InterestDtoToInterest interestDtoToInterest = new InterestDtoToInterest();

    private static final PremiumUserToPremiumUserDto premiumUserToPremiumUserDto =  new PremiumUserToPremiumUserDto(interestToInterestDto, addressToAddressDto);
    private static final PremiumUserDtoToPremiumUser premiumUserDtoToPremiumUser = new PremiumUserDtoToPremiumUser(interestDtoToInterest, addressDtoToAddress);



    private UserDtoMapperFactory() {}


    public static <T> Mapper creatUserMapper(Class<T> c) {
            if(c == PremiumUser.class) {
                return premiumUserToPremiumUserDto;
            }
            throw new IllegalArgumentException("invalid user type");
    }

    public static <T> Mapper createUserDtoMapper (Class<T> c) {
        if(c == PremiumUserDto.class) {
            return premiumUserDtoToPremiumUser;
        }
        throw new IllegalArgumentException("invalid user type");
    }
}
