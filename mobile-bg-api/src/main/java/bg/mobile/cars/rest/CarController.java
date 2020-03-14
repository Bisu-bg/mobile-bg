package bg.mobile.cars.rest;

import bg.mobile.cars.models.CarModel;
import bg.mobile.cars.service.CarService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarService carService;
  private final CarAccessValidator carAccessValidator;

  public CarController(final CarService carService,
      final CarAccessValidator carAccessValidator) {
    this.carService = carService;
    this.carAccessValidator = carAccessValidator;
  }

  @PostMapping
  public CarModel createCar(@RequestBody final CarModel car) {
    return carService.createCar(car);
  }

  @GetMapping("/all")
  public List<CarModel> getAllCars() {
    return carService.getAllCars();
  }

  @PutMapping
  public CarModel updateCar(@RequestBody final CarModel car) {
    carAccessValidator.validateUserCanEditCar(car.getUser(), car);

    return carService.updateCar(car);
  }

  @DeleteMapping("/{id}/{userId}")
  public void deleteCar(@PathVariable final String id, @PathVariable final String userId) {
    carAccessValidator.validateUserCanEditCar(userId, id);

    carService.deleteCar(id);
  }

}
