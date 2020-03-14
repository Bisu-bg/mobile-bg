package bg.mobile.users.rest;

import bg.mobile.users.model.UserModel;
import bg.mobile.users.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserController(final UserService userService,
      final BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userService = userService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @PostMapping("/register")
  public void registerUser(@RequestBody final UserModel user) {
    final String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

    user.setPassword(encodedPassword);

    userService.registerUser(user);
  }

//
//  @PostMapping("/login")
//  public void loginUser(@RequestBody final LoginRequest request) {
//    final String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
//
//    request.setPassword(encodedPassword);
//
//    userService.loginUser(request.getUsername(), request.getPassword());
//  }
}
