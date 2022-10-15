package AllThingsByAV.backend.services;


import AllThingsByAV.backend.models.Product;

public interface ProductService {
    Object[] getAll();
    Product create(Product product);
    Product get(Long id);
    Product update(Product product);
    Boolean delete(Long id);
}
