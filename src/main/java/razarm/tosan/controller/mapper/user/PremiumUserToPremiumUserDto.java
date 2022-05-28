package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.PremiumUserDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.auth.PremiumUser;

import java.time.ZoneId;
import java.util.Set;
import java.util.stream.Collectors;
@Component
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
                .isEnabled(premiumUser.getEnabled())
                .isExpired(premiumUser.getExpired())
                .isCredentialsNonExpired(premiumUser.getCredentialsNonExpired())
                .interests(
                        premiumUser.getInterests() != null
                                ? premiumUser.getInterests().stream()
                                        .map(interestToInterestDto::convert)
                                        .collect(Collectors.toUnmodifiableSet())
                                : Set.of())
                .createdAt(premiumUser.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(
                        premiumUser.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(premiumUser.getCreatedBy())
                .modifiedBy(premiumUser.getModifiedBy())
                .build();
    }
}
