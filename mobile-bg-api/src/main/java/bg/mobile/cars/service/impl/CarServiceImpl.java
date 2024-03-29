package bg.mobile.cars.service.impl;

import bg.mobile.cars.entities.Car;
import bg.mobile.cars.entities.CarRepository;
import bg.mobile.cars.models.CarModel;
import bg.mobile.cars.service.CarService;
import bg.mobile.cars.service.converters.CarConverter;
import bg.mobile.exceptions.HttpBadRequestException;
import bg.mobile.extras.service.ExtraService;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;
  private final CarConverter carConverter;

  @Transactional
  @Override
  public CarModel createCar(final CarModel model) {
    log.info("Create car BEGIN: {}", model);

    final Car entity = carConverter.convertToEntity(model);

    final Car car = carRepository.save(entity);

    final CarModel created = carConverter.convertToModel(car);

    log.info("Create car END: {}", created);

    return created;
  }

  @Override
  public void deleteCar(final String id) {
    log.info("Delete car by id BEGIN: {}", id);

    carRepository.deleteById(id);

    log.info("Delete car by id END: {}", id);
  }

  @Transactional
  @Override
  public CarModel updateCar(final CarModel model) {
    log.info("Update car BEGIN: {}", model);

    if (!carRepository.existsById(model.getId())) {
      throw new HttpBadRequestException("Car entity does not exist for id: " + model.getId());
    }

    final Car car = carConverter.convertToEntity(model);

    final CarModel updated = carConverter.convertToModel(carRepository.save(car));

    log.info("Update car END: {}", updated);

    return updated;
  }

  @Override
  public CarModel getById(final String id) {
    log.info("Get car by id BEGIN: {}", id);

    final Optional<Car> carOpt = carRepository.findById(id);

    CarModel car = null;
    if (carOpt.isPresent()) {
      car = carConverter.convertToModel(carOpt.get());
    }

    log.info("Get car by id END: {} {}", id, car);

    return car;
  }

  @Override
  public List<CarModel> getAllCars() {
    log.info("Get all cars BEGIN: ");

    final List<Car> all = carRepository.findAll();

    final List<CarModel> cars = carConverter.convertToModels(all);

    log.info("Get all cars END: {}", cars);

    return cars;
  }
}