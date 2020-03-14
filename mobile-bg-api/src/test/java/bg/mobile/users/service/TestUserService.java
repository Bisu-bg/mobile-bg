package bg.mobile.users.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import bg.mobile.users.model.UserModel;
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
    assertEquals(model.getPassword(), created.getPassword());
    assertEquals(model.getFirstName(), created.getFirstName());
    assertEquals(model.getLastName(), created.getLastName());
  }

  @Test
  public void testLoginUser() {
    final UserModel model = new UserModel(null, "petko", "password", "petkov", "petkov");

    final UserModel created = userService.registerUser(model);

    final UserModel ivan = userService.loginUser(created.getUsername(), "root");
    assertNull(ivan);

    final UserModel petko = userService.loginUser(created.getUsername(), created.getPassword());
    assertNotNull(petko);
  }
}
