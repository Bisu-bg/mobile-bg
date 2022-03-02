package bg.mobile.cars.service;

import bg.mobile.base.BaseTest;
import bg.mobile.cars.models.CarModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarService extends BaseTest {

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
}