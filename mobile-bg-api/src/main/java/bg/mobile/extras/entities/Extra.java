package bg.mobile.extras.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static bg.mobile.constants.Constants.UUID_SIZE;

@Getter
@Setter
@Entity
@Table(name = "extras")
@AllArgsConstructor
@NoArgsConstructor
public class Extra {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(length = UUID_SIZE)
  private String id;

  @Column(unique = true, nullable = false)
  private String name;
}