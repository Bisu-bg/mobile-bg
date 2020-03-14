package bg.mobile.extras.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import bg.mobile.extras.entities.Extra;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestExtraService {

  @Autowired
  private ExtraService extraService;

  @Test
  public void testCreateExtra() {
    assertNull(extraService.getByName("ABS"));

    final Extra extra = extraService.create("ABS");

    assertEquals("ABS", extra.getName());

    extraService.create("Gas");

    final String gas = extraService.getByName("Gas").getName();

    assertNotNull(gas);
  }

}
