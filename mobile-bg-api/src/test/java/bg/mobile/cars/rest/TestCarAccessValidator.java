package bg.mobile.cars.rest;

import bg.mobile.base.BaseTest;
import bg.mobile.cars.models.CarModel;
import bg.mobile.exceptions.HttpForbiddenException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCarAccessValidator extends BaseTest {

  @Test
  public void testCarAccessValidator() {
    final CarModel car = buildCar();

    final CarModel created = carService.createCar(car);

    carAccessValidator.validateUserCanEditCar(created.getUser().getId(), created.getId());

    assertThrows(
        HttpForbiddenException.class,
        () -> carAccessValidator.validateUserCanEditCar("bad id", created.getId()));
  }
}