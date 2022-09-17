package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.repository.MainRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final MainRepository mainRepository;

    public CategoryController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

}
