package bg.mobile.cars.rest;

import bg.mobile.cars.models.CarModel;
import bg.mobile.cars.service.CarService;
import bg.mobile.exceptions.HttpForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarAccessValidator {

  private final CarService carService;

  void validateUserCanEditCar(final String userId, final String carId) {
    if (userId == null || carId == null) {
      throw new HttpForbiddenException();
    }

    final CarModel car = carService.getById(carId);

    if (!userId.equals(car.getUser().getId())) {
      final String message = String
          .format("Car with id: %s does not belong to user with id: %s", carId, userId);
      throw new HttpForbiddenException(message);
    }
  }
}