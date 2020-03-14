package bg.mobile.cars.service;

import static bg.mobile.cars.entities.Condition.USED;
import static bg.mobile.cars.entities.EngineType.GASOLINE;
import static bg.mobile.cars.entities.GearBox.AUTOMATIC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import bg.mobile.cars.models.CarModel;
import bg.mobile.users.model.UserModel;
import bg.mobile.users.service.UserService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestCarService {

  @Autowired
  private CarService carService;

  @Autowired
  private UserService userService;

  @Test
  public void testCRUDCar() {
    final CarModel car = buildCar();

    final CarModel created = carService.createCar(car);

    assertEquals(car.getMake(), created.getMake());
    assertEquals(car.getModel(), created.getModel());
    assertEquals(car.getYear(), created.getYear());
    assertEquals(car.getEngineType(), created.getEngineType());
    assertEquals(car.getGearBox(), created.getGearBox());
    assertEquals(car.getCondition(), created.getCondition());
    assertEquals(car.getHorsePower(), created.getHorsePower());
    assertEquals(car.getColor(), created.getColor());
    assertEquals(car.getPrice(), created.getPrice());
    assertEquals(car.getCity(), created.getCity());
    assertEquals(car.getMileage(), created.getMileage());
    assertEquals(car.getUser().getId(), created.getUser().getId());
    assertEquals(car.getExtras(), created.getExtras());

    final CarModel byId = carService.getById(created.getId());
    assertNotNull(byId);

    byId.setModel("5");
    final CarModel updated = carService.updateCar(byId);
    assertEquals(byId.getModel(), updated.getModel());

    final List<CarModel> allCars = carService.getAllCars();
    assertTrue(allCars.size() > 0);

    carService.deleteCar(updated.getId());

    final CarModel deleted = carService.getById(updated.getId());
    assertNull(deleted);
  }

  private CarModel buildCar() {
    final UserModel user = new UserModel(null, "kiro", "1234", "Kiril", "Petkov");
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
    car.setExtras("Music,Leather Interior");
    return car;
  }

}
