package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.repositories.CategoryRepository;
import com.nimbusds.jose.util.ArrayUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping(path="/getCategories")
    public Category[] allCategories(){
        Product[] shirtsProducts = {new Product(Long.valueOf(1), "shirt 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(2), "shirt 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] sweaterProducts = {new Product(Long.valueOf(3), "sweater 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(4), "sweater 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] drinkProducts = {new Product(Long.valueOf(5), "drink ware 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(6), "drink ware 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] accessoriesProducts = {new Product(Long.valueOf(7), "accessory 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(8), "accessory 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] allProducts = ArrayUtils.concat(shirtsProducts, sweaterProducts, drinkProducts, accessoriesProducts);
        Category[] arr = {
                new Category(Long.valueOf(1), "", "Shirts", List.of(shirtsProducts)),
                new Category(Long.valueOf(2), "", "Sweaters", List.of(sweaterProducts)),
                new Category(Long.valueOf(3), "", "Drink ware", List.of(drinkProducts)),
                new Category(Long.valueOf(4), "", "accessories", List.of(accessoriesProducts)),
                new Category(Long.valueOf(5), "", "All Items", List.of(allProducts))
            };
        return arr;
    }
    @GetMapping(path="/getCategory")
    public Product[] getCategory() {
        Product[] shirtsProducts = {new Product(Long.valueOf(1), "shirt 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(2), "shirt 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] sweaterProducts = {new Product(Long.valueOf(3), "sweater 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(4), "sweater 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] drinkProducts = {new Product(Long.valueOf(5), "drink ware 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(6), "drink ware 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] accessoriesProducts = {new Product(Long.valueOf(7), "accessory 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(8), "accessory 2", "", Long.valueOf("this is description"), 99.99, true)};
        Product[] allProducts = ArrayUtils.concat(shirtsProducts, sweaterProducts, drinkProducts, accessoriesProducts);
        return allProducts;
    }
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


}
