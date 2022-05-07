package razarm.tosan.controller.mapper.user;

import razarm.tosan.controller.dto.auth.PremiumUserDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.auth.PremiumUser;

import java.time.ZoneId;
import java.util.stream.Collectors;

public class PremiumUserToPremiumUserDto implements Mapper<PremiumUser, PremiumUserDto> {
    private final InterestToInterestDto interestToInterestDto;

    public PremiumUserToPremiumUserDto(InterestToInterestDto interestToInterestDto) {
        this.interestToInterestDto = interestToInterestDto;
    }

    @Override
    public PremiumUserDto convert(PremiumUser premiumUser) {
        return PremiumUserDto.PremiumUserDtoBuilder.aPremiumUserDto()
                .id(premiumUser.getId())
                .name(premiumUser.getName())
                .username(premiumUser.getUsername())
                .phone(premiumUser.getPhone())
                .email(premiumUser.getEmail())
                .nationalId(premiumUser.getNationalId())
                .validEmail(premiumUser.getValidEmail())
                .isEnabled(premiumUser.getIsEnabled())
                .isExpired(premiumUser.getIsExpired())
                .isCredentialsNonExpired(premiumUser.getIsCredentialsNonExpired())
                .interests(premiumUser.getInterests().stream().map(interestToInterestDto::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(premiumUser.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(premiumUser.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(premiumUser.getCreatedBy())
                .modifiedBy(premiumUser.getModifiedBy())
                .build();
    }
}
