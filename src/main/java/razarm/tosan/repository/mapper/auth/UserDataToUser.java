package razarm.tosan.repository.mapper.auth;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.UserData;
import razarm.tosan.repository.domain.auth.User;

@Component
public class UserDataToUser implements Mapper<UserData, User> {
    @Override
    public User convert(UserData userData) {
        final Mapper<UserData, User> mapper = UserDataMapperFactory.createUserDataMapper(userData.getClass());
        return mapper.convert(userData);
    }
}
