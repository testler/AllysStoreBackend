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
    @GetMapping("/get/{productId}")
    Product getProduct(@PathVariable Long productId){
        return productService.get(productId);
    }

}
