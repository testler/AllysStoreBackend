package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.User;
import AllThingsByAV.backend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(path = "/create")
    public void createUser(
            String email,
            String password
    ) {
        userService.create(new User("testemail@test.com", "1234"));

    }
}
