package razarm.tosan.repository.mapper.auth;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.UserData;
import razarm.tosan.repository.domain.auth.User;

@Component
@AllArgsConstructor
@Slf4j
public class UserDataToUser implements Mapper<UserData, User> {
    private final UserDataMapperFactory userDataMapper;
    @Override
    public User convert(UserData userData) {
        final Mapper<UserData, User> mapper = userDataMapper.createUserDataMapper(userData.getClass());
        return mapper.convert(userData);
    }
}
