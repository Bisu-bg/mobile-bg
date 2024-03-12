package bg.mobile.cars.entities;

import bg.mobile.extras.entities.Extra;
import bg.mobile.users.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

import static bg.mobile.constants.Constants.UUID_SIZE;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
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