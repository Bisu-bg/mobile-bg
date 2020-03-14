package bg.mobile.users.service.impl;

import static java.util.Collections.emptyList;

import bg.mobile.users.entities.User;
import bg.mobile.users.entities.UserRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Optional<User> userOpt = userRepository.findByUsername(username);

    if (!userOpt.isPresent()) {
      throw new UsernameNotFoundException(username);
    }

    final User user = userOpt.get();

    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), emptyList());
  }
}