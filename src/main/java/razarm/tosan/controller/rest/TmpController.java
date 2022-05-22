package razarm.tosan.controller.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmpController {

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return  "Hello world";
    }
}
