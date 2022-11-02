package AllThingsByAV.backend.services;

import AllThingsByAV.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface UserService {
    User create(User user);
    User get(Long id);
    User update(User user);
    Boolean delete(Long id);
}
