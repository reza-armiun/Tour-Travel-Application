package razarm.tosan.controller.dto.auth;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import razarm.tosan.controller.dto.address.AddressInfo;
import razarm.tosan.controller.dto.tour.BookingInfo;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile {
    private String id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private Long nationalId;
    private String imageUrl;
    private AddressInfo address;
    private Set<BookingInfo> bookings;
}
