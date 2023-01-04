package AllThingsByAV.backend.services;

import AllThingsByAV.backend.models.Category;
import AllThingsByAV.backend.models.Image;

public interface ImageService {
    Image create(Image image);
    Image get(Long id);
    Image update(Image image);
    Boolean delete(Long id);
}
