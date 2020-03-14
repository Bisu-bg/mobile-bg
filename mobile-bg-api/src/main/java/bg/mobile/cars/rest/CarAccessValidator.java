package bg.mobile.cars.rest;

import bg.mobile.cars.models.CarModel;
import bg.mobile.cars.service.CarService;
import bg.mobile.exceptions.HttpForbiddenException;
import bg.mobile.users.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class CarAccessValidator {

  private final CarService carService;

  public CarAccessValidator(final CarService carService) {
    this.carService = carService;
  }

  void validateUserCanEditCar(final UserModel user, final CarModel car) {
    final String userId = user.getId();
    final String carUserId = car.getUser().getId();

    if ((userId == null || carUserId == null) || !userId.equals(carUserId)) {
      throw new HttpForbiddenException();
    }
  }

  void validateUserCanEditCar(final String userId, final String carId) {
    if (userId == null || carId == null) {
      throw new HttpForbiddenException();
    }

    final CarModel car = carService.getById(carId);

    if (!userId.equals(car.getUser().getId())) {
      throw new HttpForbiddenException();
    }
  }

}
