package bg.mobile.cars.service;

import bg.mobile.cars.models.CarModel;
import java.util.List;

public interface CarService {

  CarModel createCar(CarModel model);

  void deleteCar(String id);

  CarModel updateCar(CarModel model);

  CarModel getById(String id);

  List<CarModel> getAllCars();
}
