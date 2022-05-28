package razarm.tosan.repository.mapper.auth;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.domain.auth.PremiumUser;

@Component
public class UserDataMapperFactory {
    private static final InterestDataToInterest interestDataToInterest = new InterestDataToInterest();
    private static final InterestToInterestData interestToInterestData = new InterestToInterestData();

    private static final PremiumUserToPremiumUserData premiumUserToPremiumUserData = new PremiumUserToPremiumUserData(interestToInterestData);
    private static final PremiumUserDataToPremiumUser premiumUserDataToPremiumUser = new PremiumUserDataToPremiumUser(interestDataToInterest);

    private UserDataMapperFactory() {}



    public static <T> Mapper  createUserMapper(Class<T> c) {
        if(c == PremiumUser.class)  return premiumUserToPremiumUserData;

        throw new IllegalArgumentException("invalid user type");
    }


    public static <T> Mapper createUserDataMapper (Class<T> c) {
        if(c == PremiumUserData.class) return premiumUserDataToPremiumUser;

        throw new IllegalArgumentException("invalid user type");
    }
}
