package AllThingsByAV.backend.repositories;

import AllThingsByAV.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
