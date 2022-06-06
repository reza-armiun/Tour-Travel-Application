package razarm.tosan.repository.mapper.auth;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.UserData;
import razarm.tosan.repository.domain.auth.User;

@Component
@AllArgsConstructor
public class UserToUserData implements Mapper<User, UserData> {
    private final UserDataMapperFactory userDataMapper;
    @Override
    public UserData convert(User user) {
        final Mapper<User, UserData> mapper = userDataMapper.createUserMapper(user.getClass());
        return mapper.convert(user);
    }
}
