package razarm.tosan.controller.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.service.tour.TourService;

import java.util.List;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
public class TourController {
    private final TourService tourService;



    @GetMapping("tour")
    public ResponseEntity<List<TourDto>> getTourList() {
        return ResponseEntity.ok(this.tourService.findAll());
    }

    @GetMapping("tour/{id}")
    public ResponseEntity<TourDto> getTourItem(@PathVariable String id) {
        return  ResponseEntity.ok(tourService.findById(id));
    }

}
