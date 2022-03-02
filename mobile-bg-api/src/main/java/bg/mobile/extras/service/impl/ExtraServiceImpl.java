package bg.mobile.extras.service.impl;

import bg.mobile.extras.entities.Extra;
import bg.mobile.extras.entities.ExtraRepository;
import bg.mobile.extras.service.ExtraService;
import bg.mobile.extras.service.converters.ExtraConverter;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ExtraServiceImpl implements ExtraService {

  private final ExtraConverter extraConverter;
  private final ExtraRepository extraRepository;

  @Override
  public Extra create(final String name) {
    log.info("Create extra BEGIN: {}", name);

    if (name == null) {
      return null;
    }

    final Extra extraEntity = extraConverter.convertToEntity(name);
    final Extra created = extraRepository.save(extraEntity);

    log.info("Create extra END: {}", created);

    return created;
  }

  @Override
  public Extra getByName(final String name) {
    log.info("Get extra by name BEGIN: {}", name);

    if (name == null) {
      return null;
    }

    final Optional<Extra> extraOpt = extraRepository.findByName(name);
    final Extra extra = extraOpt.orElse(null);

    log.info("Get extra by name BEGIN: {}", extra);

    return extra;
  }
}