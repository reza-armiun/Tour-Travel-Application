package razarm.tosan.controller.dto.address;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AddressInfo {
    private String street;
    private String postalCode;
    private String city;
    private Integer zipCode;
    private String country;
    private String countryCode;
}
