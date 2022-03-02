package bg.mobile.users.service;

import bg.mobile.base.BaseTest;
import bg.mobile.exceptions.HttpUnauthorizedException;
import bg.mobile.users.model.UserModel;
import bg.mobile.users.rest.LoginResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserService extends BaseTest {

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