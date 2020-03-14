package bg.mobile.extras.entities;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraRepository extends JpaRepository<Extra, String> {

  Optional<Extra> findByName(String name);

}
