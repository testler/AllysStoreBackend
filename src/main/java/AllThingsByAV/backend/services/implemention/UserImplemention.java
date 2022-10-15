package AllThingsByAV.backend.services.implemention;

import AllThingsByAV.backend.models.User;
import AllThingsByAV.backend.repositories.UserRepository;
import AllThingsByAV.backend.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserImplemention implements UserService {
    private final UserRepository userRepository;

    public UserImplemention(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
