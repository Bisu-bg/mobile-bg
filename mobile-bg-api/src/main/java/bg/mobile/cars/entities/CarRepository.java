package bg.mobile.cars.entities;

import bg.mobile.users.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {

  List<Car> findAllByUser(User user);

}
