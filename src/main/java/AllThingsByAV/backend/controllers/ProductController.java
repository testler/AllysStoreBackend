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
        return productService.getAll();
    }
}
