package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.controller.dto.auth.UserDto;
@Component
public class UserDtoToUser implements Mapper<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        final Mapper<UserDto, User> mapper = UserDtoMapperFactory.createUserDtoMapper(userDto.getClass());
        return mapper.convert(userDto);
    }
}
