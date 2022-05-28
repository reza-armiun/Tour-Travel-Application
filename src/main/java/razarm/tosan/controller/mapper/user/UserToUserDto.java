package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.UserDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.auth.User;
@Component
public class UserToUserDto implements Mapper<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        final Mapper<User, UserDto> mapper = UserDtoMapperFactory.creatUserMapper(user.getClass());
        return mapper.convert(user);
    }
}
