package AllThingsByAV.backend.controllers;


import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.services.CategoryService;
import AllThingsByAV.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService productService;
    @Autowired
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public Object[] allProducts(){
        return productService.getAll();
    }
    @GetMapping("/get/{productID}")
    Product getProduct(@PathVariable Long productId){
        return productService.get(productId);
    }
    @PutMapping("/assignCategories")
    public Boolean assignCategories(){
        this.assignCategoryToProduct(1L, 1L);
        this.assignCategoryToProduct(1L, 2L);
        this.assignCategoryToProduct(2L, 3L);
        this.assignCategoryToProduct(2L, 4L);
        this.assignCategoryToProduct(3L, 5L);
        this.assignCategoryToProduct(3L, 6L);
        this.assignCategoryToProduct(4L, 7L);
        this.assignCategoryToProduct(4L, 8L);
        return true;
    }
    @PutMapping("/{productId}/category/{categoryId}")
    Product assignCategoryToProduct(
            @PathVariable Long categoryId,
            @PathVariable Long productId
    ){
        Category category = categoryService.get(categoryId);
        Product product = productService.get(productId);
        product.setCategory(category);
        return productService.update(product);
    }
}
