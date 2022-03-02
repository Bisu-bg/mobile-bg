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
  public void registerUser(@RequestBody final UserModel user) {
    userService.registerUser(user);
  }

  @PostMapping("/login")
  public LoginResponse loginUser(@RequestBody final LoginRequest request) {

    return userService.loginUser(request.getUsername(), request.getPassword());
  }
}