package AllThingsByAV.backend.services.implemention;

import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.repositories.ProductRepository;
import AllThingsByAV.backend.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductImplemention implements ProductService {
    private final ProductRepository productRepository;

    public ProductImplemention(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Object[] getAll() {
        return productRepository.findAll().toArray();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;
    }
}
