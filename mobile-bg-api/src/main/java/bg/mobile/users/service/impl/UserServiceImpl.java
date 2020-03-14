package bg.mobile.users.service.impl;

import bg.mobile.users.entities.User;
import bg.mobile.users.entities.UserRepository;
import bg.mobile.users.model.UserModel;
import bg.mobile.users.service.UserService;
import bg.mobile.users.service.converters.UserConverter;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserConverter userConverter;

  public UserServiceImpl(final UserRepository userRepository,
      final UserConverter userConverter) {
    this.userRepository = userRepository;
    this.userConverter = userConverter;
  }

  @Override
  public UserModel registerUser(final UserModel model) {
    log.info("Register user BEGIN: {}", model);

    final User user = userConverter.convertToEntity(model);

    final User saved = userRepository.save(user);

    log.info("Register user END: {}", saved);

    return userConverter.convertToModel(saved);
  }

  @Override
  public UserModel loginUser(final String username, final String password) {
    log.info("Login user BEGIN: {}", username);

    final Optional<User> userOpt = userRepository
        .findByUsernameAndPassword(username, password);

    final UserModel model = userOpt.map(userConverter::convertToModel).orElse(null);

    log.info("Login user END: {}", model);

    return model;
  }

}
