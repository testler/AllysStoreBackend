package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.repository.MainRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final MainRepository mainRepository;

    public OrderController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;}
}
