package razarm.tosan.repository.mapper.auth;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.domain.auth.Authority;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;

import java.util.stream.Collectors;
@Component
public class PremiumUserDataToPremiumUser implements Mapper<PremiumUserData, PremiumUser> {
    private final InterestDataToInterest interestDataToInterest;
    private final AddressDataToAddress addressDataToAddress;

    public PremiumUserDataToPremiumUser(InterestDataToInterest interestDataToInterest, AddressDataToAddress addressDataToAddress) {
        this.interestDataToInterest = interestDataToInterest;
        this.addressDataToAddress = addressDataToAddress;
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
                .imageUrl(premiumUserData.getImageUrl())
                .address(premiumUserData.getAddressData() != null ? this.addressDataToAddress.convert(premiumUserData.getAddressData()) : null)
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
