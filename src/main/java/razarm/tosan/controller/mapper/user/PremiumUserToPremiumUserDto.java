package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.PremiumUserDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.auth.PremiumUser;

import java.time.ZoneId;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class PremiumUserToPremiumUserDto implements Mapper<PremiumUser, PremiumUserDto> {
    private final InterestToInterestDto interestToInterestDto;
    private final AddressToAddressDto addressDto;

    public PremiumUserToPremiumUserDto(InterestToInterestDto interestToInterestDto, AddressToAddressDto addressDto) {
        this.interestToInterestDto = interestToInterestDto;
        this.addressDto = addressDto;
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
                .imageUrl(premiumUser.getImageUrl())
                .addressDto(premiumUser.getAddress() != null ? this.addressDto.convert(premiumUser.getAddress()) : null)
                .validEmail(premiumUser.getValidEmail())
                .isEnabled(premiumUser.getIsEnabled())
                .isExpired(premiumUser.getIsExpired())
                .isCredentialsNonExpired(premiumUser.isCredentialsNonExpired())
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
