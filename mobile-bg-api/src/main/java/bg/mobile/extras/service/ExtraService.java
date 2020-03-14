package bg.mobile.extras.service;

import bg.mobile.extras.entities.Extra;

public interface ExtraService {

  Extra create(String name);

  Extra getByName(String name);

}
