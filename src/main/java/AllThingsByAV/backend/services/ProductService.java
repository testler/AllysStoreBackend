package AllThingsByAV.backend.services;


import AllThingsByAV.backend.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Object[] getAll();
    Product create(Product product);

    Product get(Long id);

    Product update(Product product);
    Boolean delete(Long id);
}
