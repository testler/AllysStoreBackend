package AllThingsByAV.backend.repositories;

import AllThingsByAV.backend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
