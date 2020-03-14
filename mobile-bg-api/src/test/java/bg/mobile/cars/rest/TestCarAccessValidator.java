package bg.mobile.cars.rest;

import static bg.mobile.cars.entities.Condition.USED;
import static bg.mobile.cars.entities.EngineType.GASOLINE;
import static bg.mobile.cars.entities.GearBox.AUTOMATIC;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bg.mobile.cars.models.CarModel;
import bg.mobile.cars.service.CarService;
import bg.mobile.exceptions.HttpForbiddenException;
import bg.mobile.users.model.UserModel;
import bg.mobile.users.service.UserService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestCarAccessValidator {

  @Autowired
  private UserService userService;

  @Autowired
  private CarAccessValidator carAccessValidator;

  @Autowired
  private CarService carService;

  @Test
  public void testCarAccessValidator() {
    final CarModel car = buildCar();
    final UserModel user = car.getUser();

    carAccessValidator.validateUserCanEditCar(user, car);

    final UserModel wrongUser = new UserModel("bad id", "ivan", "ivanov", "ivan", "ivanov");

    assertThrows(
        HttpForbiddenException.class,
        () -> carAccessValidator.validateUserCanEditCar(wrongUser, car));

    final CarModel created = carService.createCar(car);

    carAccessValidator.validateUserCanEditCar(user, created);

    assertThrows(
        HttpForbiddenException.class,
        () -> carAccessValidator.validateUserCanEditCar(wrongUser, created));
  }

  private CarModel buildCar() {
    final UserModel user = new UserModel(null, "Kircata", "1234", "Kiril", "Petkov");
    final UserModel createdUser = userService.registerUser(user);

    final CarModel car = new CarModel();
    car.setMake("Mazda");
    car.setModel("3");
    car.setYear(2004);
    car.setEngineType(GASOLINE);
    car.setGearBox(AUTOMATIC);
    car.setCondition(USED);
    car.setHorsePower(150);
    car.setColor("Black");
    car.setPrice(new BigDecimal(12000));
    car.setCity("Sofia");
    car.setMileage(150000);
    car.setUser(createdUser);
    car.setExtras("Leather Interior");
    return car;
  }

}
