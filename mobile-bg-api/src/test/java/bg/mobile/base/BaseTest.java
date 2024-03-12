package bg.mobile.base;

import bg.mobile.cars.models.CarModel;
import bg.mobile.cars.rest.CarAccessValidator;
import bg.mobile.cars.service.CarService;
import bg.mobile.extras.service.ExtraService;
import bg.mobile.users.model.UserModel;
import bg.mobile.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static bg.mobile.cars.entities.Condition.USED;
import static bg.mobile.cars.entities.EngineType.GASOLINE;
import static bg.mobile.cars.entities.GearBox.AUTOMATIC;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
public abstract class BaseTest {

    private static final DockerImageName imageName = DockerImageName.parse("mysql:8.0.36");
    private static final MySQLContainer container;

    @Autowired
    protected UserService userService;

    @Autowired
    protected CarAccessValidator carAccessValidator;

    @Autowired
    protected CarService carService;

    @Autowired
    protected ExtraService extraService;

    static {
        container = (MySQLContainer) new MySQLContainer(imageName)
                .withReuse(true);
        container.start();
    }

    protected CarModel buildCar() {
        final UserModel user = new UserModel(null, "Kircata", "1234", "Kiril", "Petkov");
        final UserModel createdUser = userService.registerUser(user);

        final CarModel car = new CarModel();
        car.setMake("Mazda");
        car.setModel("3");
        car.setYear(2004);
        car.setEngineType(GASOLINE);
        car.setGearBox(AUTOMATIC);
        car.setCondition(USED);
        car.setHorsePower(150);
        car.setColor("Black");
        car.setPrice(new BigDecimal(12000));
        car.setCity("Sofia");
        car.setMileage(150000);
        car.setUser(createdUser);
        car.setExtras("Leather Interior");
        return car;
    }
}