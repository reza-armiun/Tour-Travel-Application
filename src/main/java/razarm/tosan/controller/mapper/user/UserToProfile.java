package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.address.AddressInfo;
import razarm.tosan.controller.dto.auth.Profile;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.auth.User;

@Component
public class UserToProfile implements Mapper<User, Profile> {
    @Override
    public Profile convert(User user) {
        var address = user.getAddress();
        var city = address != null ? address.getCity() : null;
        var country =  city !=null ? city.getCountry() : null;
        return Profile.builder()
                      .id(user.getId())
                      .name(user.getName())
                      .username(user.getUsername())
                      .phone(user.getPhone())
                      .email(user.getEmail())
                      .nationalId(user.getNationalId())
                      .imageUrl(user.getImageUrl())
                      .address(address != null? AddressInfo.builder()
                                                           .street(address.getStreet())
                                                           .postalCode(address.getPostalCode())
                                                           .city(city != null ? city.getName() : null)
                                                           .zipCode(city != null ? city.getZipCode() : null)
                                                           .country(country != null ? country.getName() : null)
                                                           .countryCode(country != null ? country.getCountryCode() : null)
                                                           .build() : null)
                      .build();
    }
}
