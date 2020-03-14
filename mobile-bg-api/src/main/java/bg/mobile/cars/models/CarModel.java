package bg.mobile.cars.models;

import bg.mobile.cars.entities.Condition;
import bg.mobile.cars.entities.EngineType;
import bg.mobile.cars.entities.GearBox;
import bg.mobile.users.model.UserModel;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

  private String id;

  private String make;

  private String model;

  private int year;

  private EngineType engineType;

  private GearBox gearBox;

  private Condition condition;

  private int horsePower;

  private String color;

  private BigDecimal price;

  private String city;

  private int mileage;

  private UserModel user;

  private String extras;

}
