package razarm.tosan.repository.mapper.auth;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.auth.Authority;
import razarm.tosan.repository.domain.auth.PremiumUser;

import java.util.Set;
import java.util.stream.Collectors;

public class PremiumUserToPremiumUserData implements Mapper<PremiumUser, PremiumUserData> {
    private final InterestToInterestData interestToInterestData;

    public PremiumUserToPremiumUserData(InterestToInterestData interestToInterestData) {
        this.interestToInterestData = interestToInterestData;
    }

    @Override
    public PremiumUserData convert(PremiumUser premiumUser) {
        return PremiumUserData.PremiumUserDataBuilder.aPremiumUserData()
                .id(premiumUser.getId())
                .name(premiumUser.getName())
                .username(premiumUser.getUsername())
                .password(premiumUser.getPassword())
                .email(premiumUser.getEmail())
                .phone(premiumUser.getPhone())
                .nationalId(premiumUser.getNationalId())
                .type(premiumUser.getType())
                .authorities(
                        premiumUser.getAuthorities().stream()
                                .map(Authority::getName)
                                .collect(Collectors.toUnmodifiableSet()))
                .validEmail(premiumUser.getValidEmail())
                .isExpired(premiumUser.getExpired())
                .isEnabled(premiumUser.getEnabled())
                .isCredentialsNonExpired(premiumUser.getCredentialsNonExpired())
                //
                // .authorityIds(premiumUser.getAuthorities().stream().map(BaseEntity::getId).collect(Collectors.toUnmodifiableSet()))
                .bookingIds(
                        premiumUser.getBookings() != null
                                ? premiumUser.getBookings().stream()
                                        .map(BaseEntity::getId)
                                        .collect(Collectors.toUnmodifiableSet())
                                : Set.of())
                .interests(premiumUser.getInterests() != null ?
                        premiumUser.getInterests().stream()
                                .map(this.interestToInterestData::convert)
                                .collect(Collectors.toUnmodifiableSet()) : Set.of())
                .createdAt(premiumUser.getCreatedAt())
                .modifiedAt(premiumUser.getModifiedAt())
                .createdBy(premiumUser.getCreatedBy())
                .modifiedBy(premiumUser.getModifiedBy())
                .build();
    }
}
