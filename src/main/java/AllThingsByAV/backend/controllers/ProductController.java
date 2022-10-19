package AllThingsByAV.backend.controllers;


import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public Object[] allProducts(){
        productService.create(new Product(Long.valueOf(1), "shirt 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(2), "shirt 2", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(3), "sweater 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(4), "sweater 2", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(5), "drink ware 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(6), "drink ware 2", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(7), "accessory 1", "", "this is description", 99.99, true));
        productService.create(new Product(Long.valueOf(8), "accessory 2", "", "this is description", 99.99, true));
        return productService.getAll();
    }
}
