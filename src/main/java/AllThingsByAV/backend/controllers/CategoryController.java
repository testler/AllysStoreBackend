package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.repositories.CategoryRepository;
import AllThingsByAV.backend.services.CategoryService;
import AllThingsByAV.backend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping(path="/start")
    public Boolean startData(){
        categoryService.create(new Category(Long.valueOf(1), "", "Shirts", new HashSet<Product>()));
        categoryService.create(new Category(Long.valueOf(2), "", "Sweaters", new HashSet<Product>()));
        categoryService.create(new Category(Long.valueOf(3), "", "Drink ware", new HashSet<Product>()));
        categoryService.create(new Category(Long.valueOf(4), "", "accessories", new HashSet<Product>()));
        productService.create(new Product(Long.valueOf(1), "shirt 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(2), "shirt 2", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(3), "sweater 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(4), "sweater 2", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(5), "drink ware 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(6), "drink ware 2", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(7), "accessory 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(8), "accessory 2", "", "this is description", 99.99, true));
        this.addProductToCategory(Long.valueOf(1),Long.valueOf(1));
        this.addProductToCategory(Long.valueOf(1),Long.valueOf(2));
        this.addProductToCategory(Long.valueOf(2),Long.valueOf(3));
        this.addProductToCategory(Long.valueOf(2),Long.valueOf(4));
        this.addProductToCategory(Long.valueOf(3),Long.valueOf(5));
        this.addProductToCategory(Long.valueOf(3),Long.valueOf(6));
        this.addProductToCategory(Long.valueOf(4),Long.valueOf(7));
        this.addProductToCategory(Long.valueOf(4),Long.valueOf(8));

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
        product.setCategory(category);
        productService.update(product);
        categoryService.update(category);
        return category;
    }
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


}
