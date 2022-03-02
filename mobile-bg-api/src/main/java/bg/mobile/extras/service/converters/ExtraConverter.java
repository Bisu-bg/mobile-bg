package bg.mobile.extras.service.converters;

import bg.mobile.extras.entities.Extra;
import org.springframework.stereotype.Component;

@Component
public class ExtraConverter {

  public Extra convertToEntity(final String name) {
    if (name == null) {
      return null;
    }

    return new Extra(null, name);
  }
}