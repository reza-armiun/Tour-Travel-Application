package razarm.tosan.repository.mapper.auth;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.domain.auth.Authority;
import razarm.tosan.repository.domain.auth.PremiumUser;

import java.util.stream.Collectors;

public class PremiumUserDataToPremiumUser implements Mapper<PremiumUserData, PremiumUser> {
    private final InterestDataToInterest interestDataToInterest;

    public PremiumUserDataToPremiumUser(InterestDataToInterest interestDataToInterest) {
        this.interestDataToInterest = interestDataToInterest;
    }

    @Override
    public PremiumUser convert(PremiumUserData premiumUserData) {
        return PremiumUser.PremiumUserBuilder.aPremiumUser()
                .id(premiumUserData.getId())
                .name(premiumUserData.getName())
                .username(premiumUserData.getUsername())
                .password(premiumUserData.getPassword())
                .email(premiumUserData.getEmail())
                .phone(premiumUserData.getPhone())
                .authorities(
                        premiumUserData.getAuthorities().stream()
                                .map(s -> Authority.AuthorityBuilder.anAuthority().name(s).build())
                                .collect(Collectors.toUnmodifiableSet())) // todo refactor
                .nationalId(premiumUserData.getNationalId())
                .validEmail(premiumUserData.getValidEmail())
                .isEnabled(premiumUserData.getEnabled())
                .isExpired(premiumUserData.getExpired())
                .isCredentialsNonExpired(premiumUserData.getCredentialsNonExpired())
                .interests(
                        premiumUserData.getInterests().stream()
                                .map(interestDataToInterest::convert)
                                .collect(Collectors.toUnmodifiableSet()))
                .build();
    }
}
