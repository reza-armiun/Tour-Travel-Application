package razarm.tosan.controller.dto.tour;


import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingInfo {
    private String id;
    private String tourName;
    private ZonedDateTime date;
}
