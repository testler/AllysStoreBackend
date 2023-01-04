package AllThingsByAV.backend.services.implemention;

import AllThingsByAV.backend.models.Image;
import AllThingsByAV.backend.models.Product;
import AllThingsByAV.backend.repositories.ImageRepository;
import AllThingsByAV.backend.repositories.ProductRepository;
import AllThingsByAV.backend.services.ImageService;
import AllThingsByAV.backend.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImageImplemention implements ImageService {

    private final ImageRepository imageRepository;

    public ImageImplemention(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image get(Long id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public Image update(Image image) {
        return imageRepository.saveAndFlush(image);
    }

    @Override
    public Boolean delete(Long id) {
        imageRepository.deleteById(id);
        return true;
    }
}

