package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.User;
import AllThingsByAV.backend.services.UserService;
import com.squareup.square.models.Money;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("/login")
    public User login(@RequestBody Object posU){
        System.out.println(posU);
        return null;
    }
    @PostMapping(path = "/create")
    public void createUser(
            String email,
            String password
    ) {
        userService.create(new User("testemail@test.com", "1234"));

    }
}
