package bg.mobile.extras.service;

import bg.mobile.base.BaseTest;
import bg.mobile.extras.entities.Extra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestExtraService extends BaseTest {

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