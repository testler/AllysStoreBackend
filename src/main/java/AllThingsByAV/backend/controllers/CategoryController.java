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
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final ProductService productService;
    @GetMapping(path="/start")
    public Boolean startData(){
//        productService.create(new Product(Long.valueOf(1), "shirt 1", new File("/home/testler/CompSciProjects/java/backend/src/main/resources/static/shirts.jpeg"), "this is description", 99.99, true));
//        productService.create(new Product(Long.valueOf(2), "shirt 2", "", "this is description", 99.99, true));
//        productService.create(new Product(Long.valueOf(3), "sweater 1", "", "this is description", 99.99, true));
//        productService.create(new Product(Long.valueOf(4), "sweater 2", "", "this is description", 99.99, true));
//        productService.create(new Product(Long.valueOf(5), "drink ware 1", "", "this is description", 99.99, true));
//        productService.create(new Product(Long.valueOf(6), "drink ware 2", "", "this is description", 99.99, true));
//        productService.create(new Product(Long.valueOf(7), "accessory 1", "", "this is description", 99.99, true));
//        productService.create(new Product(Long.valueOf(8), "accessory 2", "", "this is description", 99.99, true));
//        Category cat1 = new Category(Long.valueOf(1), "/home/testler/CompSciProjects/java/backend/src/main/resources/static/shirts.jpeg", "Shirts");
//        Category cat2 = new Category(Long.valueOf(2), "/home/testler/CompSciProjects/java/backend/src/main/resources/static/sweatshirts.jpeg", "Sweaters");
//        Category cat3 = new Category(Long.valueOf(3), "/home/testler/CompSciProjects/java/backend/src/main/resources/static/drinkWare.jpeg", "Drink ware");
//        Category cat4 = new Category(Long.valueOf(4), "/home/testler/CompSciProjects/java/backend/src/main/resources/static/accerories.jpeg", "accessories");
//        categoryService.create(cat1);
//        categoryService.create(cat2);
//        categoryService.create(cat3);
//        categoryService.create(cat4);
        return true;
    }
    @GetMapping(path="/")
    public Object[] allCategories(){
        return categoryService.getAll();
    }
    @GetMapping(path="/get/{id}")
    public Object getCategory(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @PutMapping("/{categoryId}/product/{productId}")
    Category addProductToCategory(
            @PathVariable Long categoryId,
            @PathVariable Long productId
    ){
        Category category = categoryService.get(categoryId);
        Product product = productService.get(productId);
        category.addProduct(product);
        return categoryService.update(category);
    }
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


}
