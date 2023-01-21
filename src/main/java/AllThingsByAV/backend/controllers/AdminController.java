package AllThingsByAV.backend.controllers;
import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Image;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.services.CategoryService;
import AllThingsByAV.backend.services.ImageService;
import AllThingsByAV.backend.services.ProductService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin")
public class AdminController {
    CategoryService categoryService;
    ProductService productService;
    ImageService imageService;
    @GetMapping("/")
    public Object[] AllProducts(){
        return productService.getAll();
    }
    @PostMapping("/newProduct")
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
    @PutMapping("/editProduct")
    public Product editProduct(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping("/deleteProduct/{productId}")
    public boolean destroyProduct(@RequestParam Long productId){
        return productService.delete(productId);
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
    @PostMapping("/newCategory/")
    public Category createCategory(@RequestBody Category category){
        return categoryService.create(category);
    }
    @DeleteMapping("/deleteCategory/{categoryId}")
    public Boolean destroyCategory(@RequestParam Long categoryId){
        return categoryService.delete(categoryId);
    }
    @GetMapping("/startDatabases")
    public Boolean start() {
        Category cat1 = new Category(Long.valueOf(1), new Image(), "Shirts");
        Category cat2 = new Category(Long.valueOf(2), new Image(), "Sweaters");
        Category cat3 = new Category(Long.valueOf(3), new Image(), "Drink ware");
        Category cat4 = new Category(Long.valueOf(4), new Image(), "accessories");
        categoryService.create(cat1);
        categoryService.create(cat2);
        categoryService.create(cat3);
        categoryService.create(cat4);
        return false;
    }

    @PostMapping("/newImage")
    public Image createImage(@RequestBody MultipartFile image) throws IOException {
        return imageService.create(new Image(image));
    }
    @GetMapping("/image/{imageId}")
    public Image getImage(@RequestParam Long imageId){
        return imageService.get(imageId);
    }
}

