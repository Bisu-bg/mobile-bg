package bg.mobile.cars.service.converters;

import bg.mobile.cars.entities.Car;
import bg.mobile.cars.models.CarModel;
import bg.mobile.extras.entities.Extra;
import bg.mobile.extras.service.ExtraService;
import bg.mobile.users.service.converters.UserConverter;
import com.mysql.cj.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Component
@RequiredArgsConstructor
public class CarConverter {

  private final UserConverter userConverter;
  private final ExtraService extraService;

  public CarModel convertToModel(final Car car) {
    if (car == null) {
      return null;
    }

    final CarModel model = new CarModel();
    model.setId(car.getId());
    model.setMake(car.getMake());
    model.setModel(car.getModel());
    model.setYear(car.getYear());
    model.setEngineType(car.getEngineType());
    model.setGearBox(car.getGearBox());
    model.setCondition(car.getCondition());
    model.setHorsePower(car.getHorsePower());
    model.setColor(car.getColor());
    model.setPrice(car.getPrice());
    model.setCity(car.getCity());
    model.setMileage(car.getMileage());
    model.setUser(userConverter.convertToModel(car.getUser()));
    model.setExtras(toExtras(car.getExtras()));

    return model;
  }

  private String toExtras(final Set<Extra> extras) {
    if (extras == null || extras.isEmpty()) {
      return null;
    }

    return String.join(",", extras.stream().map(Extra::getName).collect(toSet()));
  }

  public Car convertToEntity(final CarModel model) {
    if (model == null) {
      return null;
    }

    final Car car = new Car();
    car.setId(model.getId());
    car.setMake(model.getMake());
    car.setModel(model.getModel());
    car.setYear(model.getYear());
    car.setEngineType(model.getEngineType());
    car.setGearBox(model.getGearBox());
    car.setCondition(model.getCondition());
    car.setHorsePower(model.getHorsePower());
    car.setColor(model.getColor());
    car.setPrice(model.getPrice());
    car.setCity(model.getCity());
    car.setMileage(model.getMileage());
    car.setUser(userConverter.convertToEntity(model.getUser()));
    car.setExtras(createExtrasIfMissing(model.getExtras()));

    return car;
  }

  private Set<Extra> createExtrasIfMissing(final String extras) {
    if (StringUtils.isNullOrEmpty(extras)) {
      return null;
    }

    final Set<String> extrasSet = new HashSet<>(Arrays.asList(extras.split(",")));
    final Set<Extra> entities = new HashSet<>();

    extrasSet.forEach(extra -> {
      final Extra byName = extraService.getByName(extra);
      if (byName != null) {
        entities.add(byName);
      } else {
        entities.add(extraService.create(extra));
      }
    });

    return entities;
  }

  public List<CarModel> convertToModels(final List<Car> cars) {
    if (cars == null || cars.isEmpty()) {
      return new ArrayList<>();
    }

    return cars.stream().map(this::convertToModel).collect(toList());
  }
}