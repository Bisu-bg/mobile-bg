package bg.mobile.cars.entities;

import static bg.mobile.constants.Constants.UUID_SIZE;

import bg.mobile.extras.entities.Extra;
import bg.mobile.users.entities.User;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
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
