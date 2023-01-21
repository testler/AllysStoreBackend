package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.repositories.CategoryRepository;
import AllThingsByAV.backend.services.CategoryService;
import AllThingsByAV.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;
    @GetMapping(path="/")
    public Object[] allCategories(){
        return categoryService.getAll();
    }
    @GetMapping(path="/get/{id}")
    public Object getCategory(@PathVariable Long id) {
        return categoryService.get(id);
    }





}
