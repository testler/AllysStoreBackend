package AllThingsByAV.backend.repositories;

import AllThingsByAV.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
