package razarm.tosan.controller.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.service.tour.BookingService;

import java.security.Principal;

@Controller
@RequestMapping("v1")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;


    @GetMapping("booking/{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable String id, Principal principal) {
        return ResponseEntity.ok(this.bookingService.findById(principal.getName(), id));
    }
}
