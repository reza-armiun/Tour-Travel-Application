package razarm.tosan.controller.mapper.user;

import razarm.tosan.controller.dto.auth.PremiumUserDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.auth.PremiumUser;

public class UserDtoMapperFactory {
    private static final InterestToInterestDto  interestToInterestDto =  new InterestToInterestDto();
    private static final InterestDtoToInterest interestDtoToInterest = new InterestDtoToInterest();

    private static final PremiumUserToPremiumUserDto premiumUserToPremiumUserDto =  new PremiumUserToPremiumUserDto(interestToInterestDto);
    private static final PremiumUserDtoToPremiumUser premiumUserDtoToPremiumUser = new PremiumUserDtoToPremiumUser(interestDtoToInterest);



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
