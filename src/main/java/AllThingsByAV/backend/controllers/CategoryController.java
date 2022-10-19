package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.repositories.CategoryRepository;
import AllThingsByAV.backend.services.CategoryService;
import com.nimbusds.jose.util.ArrayUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping(path="/")
    public Object[] allCategories(){
        categoryService.create(new Category(Long.valueOf(1), "", "Shirts", Set.of()));
        categoryService.create(new Category(Long.valueOf(2), "", "Sweaters", Set.of()));
        categoryService.create(new Category(Long.valueOf(3), "", "Drink ware", Set.of()));
        categoryService.create(new Category(Long.valueOf(4), "", "accessories", Set.of()));
        categoryService.create(new Category(Long.valueOf(5), "", "All Items", Set.of()));


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
