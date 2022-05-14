package razarm.tosan.repository.mapper.auth;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.UserData;
import razarm.tosan.repository.domain.auth.User;

public class UserToUserData implements Mapper<User, UserData> {
    @Override
    public UserData convert(User user) {
        final Mapper<User, UserData> mapper = UserDataMapperFactory.createUserMapper(user.getClass());
        return mapper.convert(user);
    }
}
