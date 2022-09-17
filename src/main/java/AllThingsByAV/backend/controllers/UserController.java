package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.repository.MainRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final MainRepository mainRepository;

    public UserController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }
}
