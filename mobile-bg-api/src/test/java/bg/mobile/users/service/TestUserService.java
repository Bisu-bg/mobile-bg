package bg.mobile.users.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bg.mobile.exceptions.HttpUnauthorizedException;
import bg.mobile.users.model.UserModel;
import bg.mobile.users.rest.LoginResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestUserService {

  @Autowired
  private UserService userService;

  @Test
  public void testRegisterUser() {
    final UserModel model = new UserModel(null, "kiril", "password", "kiril", "petkov");

    final UserModel created = userService.registerUser(model);

    assertEquals(model.getUsername(), created.getUsername());
    assertEquals(model.getFirstName(), created.getFirstName());
    assertEquals(model.getLastName(), created.getLastName());
  }

  @Test
  public void testLoginUser() {
    final UserModel model = new UserModel(null, "petko", "password", "petkov", "petkov");

    final UserModel created = userService.registerUser(model);

    assertThrows(
        HttpUnauthorizedException.class,
        () -> userService.loginUser(created.getUsername(), "root"));

    final LoginResponse petkoLogin = userService.loginUser(created.getUsername(), "password");
    assertNotNull(petkoLogin.getUser());
    assertNotNull(petkoLogin.getJwtToken());
  }
}
