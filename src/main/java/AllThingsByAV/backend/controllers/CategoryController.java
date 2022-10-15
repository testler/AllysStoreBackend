package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.repositories.CategoryRepository;
import AllThingsByAV.backend.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping(path="/getCategories")
    public Object[] allCategories(){
        return categoryService.getAll();
    }
    @GetMapping(path="/getCategory")
    public Object getCategory(Long id) {
        return categoryService.get(id);
    }
    
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


}
