package bg.mobile.users.service.impl;

import static bg.mobile.config.security.PasswordEncoder.checkPassword;
import static bg.mobile.config.security.PasswordEncoder.hashPassword;
import static bg.mobile.config.security.SecurityConstants.EXPIRATION_TIME;
import static bg.mobile.config.security.SecurityConstants.SECRET;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import bg.mobile.exceptions.HttpUnauthorizedException;
import bg.mobile.users.entities.User;
import bg.mobile.users.entities.UserRepository;
import bg.mobile.users.model.UserModel;
import bg.mobile.users.rest.LoginResponse;
import bg.mobile.users.service.UserService;
import bg.mobile.users.service.converters.UserConverter;
import com.auth0.jwt.JWT;
import java.util.Date;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserConverter userConverter;

  @Override
  public UserModel registerUser(final UserModel model) {
    log.info("Register user BEGIN: {}", model);

    model.setPassword(hashPassword(model.getPassword()));

    final User user = userConverter.convertToEntity(model);

    final User saved = userRepository.save(user);

    log.info("Register user END: {}", saved);

    return userConverter.convertToModel(saved);
  }

  @Override
  public LoginResponse loginUser(final String username, final String password) {
    log.info("Login user BEGIN: {}", username);

    final User user = getUser(username);

    if (!checkPassword(password, user.getPassword())) {
      throw new HttpUnauthorizedException();
    }

    final String jwtToken = JWT.create()
        .withSubject(username)
        .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .sign(HMAC512(SECRET.getBytes()));

    final UserModel userModel = userConverter.convertToModel(user);

    final LoginResponse response = new LoginResponse(userModel, jwtToken);

    log.info("Login user END: {}", response);

    return response;
  }

  private User getUser(final String username) {
    final Optional<User> userOpt = userRepository
        .findByUsername(username);

    return userOpt.orElse(null);
  }
}