package bg.mobile.extras.entities;

import static bg.mobile.constants.Constants.UUID_SIZE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "extras")
@AllArgsConstructor
@NoArgsConstructor
public class Extra {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id", length = UUID_SIZE)
  private String id;

  @Column(unique = true, nullable = false)
  private String name;
}