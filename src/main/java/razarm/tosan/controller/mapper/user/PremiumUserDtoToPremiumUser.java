package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.PremiumUserDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.repository.domain.auth.PremiumUser;

import java.util.stream.Collectors;
@Component
public class PremiumUserDtoToPremiumUser implements Mapper<PremiumUserDto, PremiumUser> {
    private final InterestDtoToInterest interestDtoInterest;
    private final AddressDtoToAddress addressDtoToAddress;


    public PremiumUserDtoToPremiumUser(InterestDtoToInterest interestDtoInterest, AddressDtoToAddress addressDtoToAddress) {
        this.interestDtoInterest = interestDtoInterest;
        this.addressDtoToAddress = addressDtoToAddress;
    }

    @Override
    public PremiumUser convert(PremiumUserDto premiumUserDto) {
        return PremiumUser.PremiumUserBuilder.aPremiumUser()
                .id(premiumUserDto.getId())
                .name(premiumUserDto.getName())
                .username(premiumUserDto.getUsername())
                .email(premiumUserDto.getEmail())
                .phone(premiumUserDto.getPhone())
                .nationalId(premiumUserDto.getNationalId())
                .imageUrl(premiumUserDto.getImageUrl())
                .address(premiumUserDto.getAddress() != null ? this.addressDtoToAddress.convert(premiumUserDto.getAddress()): null)
                .validEmail(premiumUserDto.getValidEmail())
                .isEnabled(premiumUserDto.getEnabled())
                .isExpired(premiumUserDto.getExpired())
                .isCredentialsNonExpired(premiumUserDto.getCredentialsNonExpired())
    //            .authorities(premiumUserDto.getAuthorities())
//                .bookings(premiumUserDto.getBookings().stream().map(bookingDtoToBooking::convert).collect(Collectors.toUnmodifiableSet()))
                .interests(premiumUserDto.getInterests().stream().map(interestDtoInterest::convert).collect(Collectors.toUnmodifiableSet()))
                .createdAt(premiumUserDto.getCreatedAt().toInstant())
                .modifiedAt(premiumUserDto.getModifiedAt().toInstant())
                .createdBy(premiumUserDto.getCreatedBy())
                .modifiedBy(premiumUserDto.getModifiedBy())
                .build();
    }
}
