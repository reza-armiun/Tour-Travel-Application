package razarm.tosan.controller.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.service.tour.TourService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
public class TourController {
    private final TourService tourService;



    @GetMapping("tour")
    public ResponseEntity<List<TourDto>> getTourList() {
        return ResponseEntity.status(HttpStatus.OK)
                             .cacheControl(CacheControl.maxAge(2, TimeUnit.MINUTES))
                             .body(this.tourService.findAll());
    }

    @GetMapping("tour/{id}")
    public ResponseEntity<TourDto> getTourItem(@PathVariable String id) {
        return  ResponseEntity.ok(tourService.findById(id));
    }


    @PostMapping("tour")
    public ResponseEntity<String> saveTour(@RequestBody TourDto tourDto) {
        var newTour = this.tourService.create(tourDto);
        return ResponseEntity.ok(newTour.getId());
    }

}
