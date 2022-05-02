package razarm.tosan.controller.mapper.user;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.controller.dto.auth.UserDto;
import razarm.tosan.props.AppProperties;

import java.time.ZoneId;

public class PremiumUserToPremiumUserDto implements Mapper<PremiumUser, UserDto> {
    @Override
    public UserDto convert(PremiumUser premiumUser) {
        return UserDto.UserDtoBuilder.anUserDto()
                .name(premiumUser.getName())
                .username(premiumUser.getUsername())
                .email(premiumUser.getEmail())
                .phone(premiumUser.getPhone())
                .nationalId(premiumUser.getNationalId())
                .createdAt(premiumUser.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(
                        premiumUser.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(premiumUser.getCreatedBy())
                .modifiedBy(premiumUser.getModifiedBy())
                .build();
    }
}
