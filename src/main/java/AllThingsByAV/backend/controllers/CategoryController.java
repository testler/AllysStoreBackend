package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.repositories.CategoryRepository;
import AllThingsByAV.backend.services.CategoryService;
import AllThingsByAV.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Product p1 = new Product(Long.valueOf(2), "shirt 2", "", "this is description", 99.99, true);
        Product p2 = new Product(Long.valueOf(3), "sweater 1", "", "this is description", 99.99, true);
        Product p3 = new Product(Long.valueOf(1), "shirt 1", "", "this is description", 99.99, true);
        Product p4 = new Product(Long.valueOf(4), "sweater 2", "", "this is description", 99.99, true);
        Product p5 = new Product(Long.valueOf(5), "drink ware 1", "", "this is description", 99.99, true);
        Product p6 = new Product(Long.valueOf(6), "drink ware 2", "", "this is description", 99.99, true);
        Product p7 = new Product(Long.valueOf(7), "accessory 1", "", "this is description", 99.99, true);
        productService.create(p1);
        productService.create(p2);
        productService.create(p3);
        productService.create(p4);
        productService.create(p5);
        productService.create(p6);
        productService.create(p7);
        productService.create(new Product(Long.valueOf(8), "accessory 2", "", "this is description", 99.99, true));
        Category cat1 = new Category(Long.valueOf(1), "", "Shirts", Arrays.asList(p1, p2));
        Category cat2 = new Category(Long.valueOf(2), "", "Sweaters", Arrays.asList(p3, p4));
        Category cat3 = new Category(Long.valueOf(3), "", "Drink ware", Arrays.asList(p5, p6));
        Category cat4 = new Category(Long.valueOf(4), "", "accessories", Arrays.asList(p7));
        categoryService.create(cat1);
        categoryService.create(cat2);
        categoryService.create(cat3);
        categoryService.create(cat4);
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
