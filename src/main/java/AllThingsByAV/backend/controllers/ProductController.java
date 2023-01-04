package AllThingsByAV.backend.controllers;


import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Image;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.services.CategoryService;
import AllThingsByAV.backend.services.ImageService;
import AllThingsByAV.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService productService;
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final ImageService imageService;

    public ProductController(ProductService productService, CategoryService categoryService, ImageService imageService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.imageService = imageService;
    }

    @GetMapping("/")
    public Object[] allProducts(){
        return productService.getAll();
    }
    @GetMapping("/get/{productID}")
    Product getProduct(@PathVariable Long productId){
        return productService.get(productId);
    }
    @PostMapping("/new")
    Product createProduct(@RequestParam String name, @RequestParam List<MultipartFile> images, @RequestParam String description, @RequestParam Double price, @RequestParam int stock){
        List<Image> imgArr = new ArrayList<>();
        images.forEach((image) -> {
            try {
                imgArr.add(imageService.create(new Image(image)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return productService.create(new Product(name,imgArr,description,price,stock));
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
