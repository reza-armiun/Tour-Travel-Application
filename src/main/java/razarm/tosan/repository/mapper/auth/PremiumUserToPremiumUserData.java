package razarm.tosan.repository.mapper.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.auth.Authority;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;
import razarm.tosan.repository.mapper.location.AddressToAddressData;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PremiumUserToPremiumUserData implements Mapper<PremiumUser, PremiumUserData> {
    private final InterestToInterestData interestToInterestData;
    private final AddressToAddressData addressToAddressData;


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
                .addressData(premiumUser.getAddress() != null ? this.addressToAddressData.convert(premiumUser.getAddress()) : null)
                .imageUrl(premiumUser.getImageUrl())
                .type(premiumUser.getType())
                .authorities(
                        premiumUser.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toUnmodifiableSet()))
                .validEmail(premiumUser.getValidEmail())
                .isExpired(premiumUser.getIsExpired())
                .isEnabled(premiumUser.getIsEnabled())
                .isCredentialsNonExpired(premiumUser.getIsCredentialsNonExpired())
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
