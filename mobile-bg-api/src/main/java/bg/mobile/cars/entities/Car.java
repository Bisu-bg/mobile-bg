package bg.mobile.cars.entities;

import bg.mobile.extras.entities.Extra;
import bg.mobile.users.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import static bg.mobile.constants.Constants.UUID_SIZE;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(length = UUID_SIZE)
  private String id;

  @Column(nullable = false)
  private String make;

  @Column(nullable = false)
  private String model;

  @Column(nullable = false)
  private int year;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EngineType engineType;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private GearBox gearBox;

  @Enumerated(EnumType.STRING)
  @Column(name = "\"condition\"", nullable = false)
  private Condition condition;

  @Column(nullable = false)
  private int horsePower;

  @Column(nullable = false)
  private String color;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private int mileage;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false,
      foreignKey = @ForeignKey(name = "fk_cars_users"))
  private User user;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "car_extras",
      joinColumns = {@JoinColumn(name = "car_id", nullable = false,
          foreignKey = @ForeignKey(name = "fk_car_extras_cars"))},
      inverseJoinColumns = {@JoinColumn(name = "car_extra_id", nullable = false,
          foreignKey = @ForeignKey(name = "fk_car_extras_extras"))})
  private Set<Extra> extras;
}