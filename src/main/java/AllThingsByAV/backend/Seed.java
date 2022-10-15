package AllThingsByAV.backend;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import com.nimbusds.jose.util.ArrayUtils;

import java.util.Set;

public class Seed {
    Product[] shirtsProducts = {new Product(Long.valueOf(1), "shirt 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(2), "shirt 2", "", Long.valueOf("this is description"), 99.99, true)};
    Product[] sweaterProducts = {new Product(Long.valueOf(3), "sweater 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(4), "sweater 2", "", Long.valueOf("this is description"), 99.99, true)};
    Product[] drinkProducts = {new Product(Long.valueOf(5), "drink ware 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(6), "drink ware 2", "", Long.valueOf("this is description"), 99.99, true)};
    Product[] accessoriesProducts = {new Product(Long.valueOf(7), "accessory 1", "", Long.valueOf("this is description"), 99.99, true), new Product(Long.valueOf(8), "accessory 2", "", Long.valueOf("this is description"), 99.99, true)};
    Product[] allProducts = ArrayUtils.concat(shirtsProducts, sweaterProducts, drinkProducts, accessoriesProducts);
    Category[] arr = {
            new Category(Long.valueOf(1), "", "Shirts", Set.of(shirtsProducts)),
            new Category(Long.valueOf(2), "", "Sweaters", Set.of(sweaterProducts)),
            new Category(Long.valueOf(3), "", "Drink ware", Set.of(drinkProducts)),
            new Category(Long.valueOf(4), "", "accessories", Set.of(accessoriesProducts)),
            new Category(Long.valueOf(5), "", "All Items", Set.of(allProducts))
    };

}

