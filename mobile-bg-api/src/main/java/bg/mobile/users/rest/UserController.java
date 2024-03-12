package bg.mobile.users.rest;

import bg.mobile.users.model.UserModel;
import bg.mobile.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody final UserModel user) {
        try {
            userService.registerUser(user);
        } catch (Exception e) {
            return "There was a problem creating the user";
        }
        return "Success";
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody final LoginRequest request) {
        try {
            return userService.loginUser(request.getUsername(), request.getPassword());
        } catch (Exception e) {
            return LoginResponse.builder().user(null).jwtToken(null).build();
        }
    }
}