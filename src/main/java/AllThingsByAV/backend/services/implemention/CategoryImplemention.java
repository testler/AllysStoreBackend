package AllThingsByAV.backend.services.implemention;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.repositories.CategoryRepository;
import AllThingsByAV.backend.services.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryImplemention implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryImplemention(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Object[] getAll() {
        return categoryRepository.findAll().toArray();
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category get(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean delete(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
