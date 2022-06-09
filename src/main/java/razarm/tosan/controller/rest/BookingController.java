package razarm.tosan.controller.rest;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.service.tour.BookingService;

import java.security.Principal;

@Controller
@RequestMapping("v1")
@AllArgsConstructor
@Slf4j
public class BookingController {
    private final BookingService bookingService;


    @GetMapping("booking/{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable String id, Principal principal) {
        return ResponseEntity.ok(this.bookingService.findById(principal.getName(), id));
    }

    @PostMapping("booking")
    public ResponseEntity<BookingDto> bookingTour
            (@RequestBody BookingDto booking
            , @RequestParam("tour-id")String tourId
            , Authentication authentication) {
        log.debug("booking :{}", booking);

        return ResponseEntity.ok(this.bookingService.bookingTour(authentication.getName(), tourId, booking));
//        return ResponseEntity.ok(this.bookingService.bookingTour(authentication.getName(), tourId, booking));
    }
}
