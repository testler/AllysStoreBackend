package AllThingsByAV.backend.services;


import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Object[] getAll();
    Category create(Category category);
    Category get(Long id);
    Category update(Category category);
    Boolean delete(Long id);
}
