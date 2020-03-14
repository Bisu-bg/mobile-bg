package bg.mobile.config.security.jwt;

import bg.mobile.users.model.UserModel;
import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static bg.mobile.config.security.SecurityConstants.EXPIRATION_TIME;
import static bg.mobile.config.security.SecurityConstants.HEADER_STRING;
import static bg.mobile.config.security.SecurityConstants.SECRET;
import static bg.mobile.config.security.SecurityConstants.TOKEN_PREFIX;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(final AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(final HttpServletRequest req, final HttpServletResponse res)
      throws AuthenticationException {
    try {
      final UserModel creds = new ObjectMapper()
          .readValue(req.getInputStream(), UserModel.class);

      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              creds.getUsername(),
              creds.getPassword(),
              new ArrayList<>())
      );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(final HttpServletRequest req,
      final HttpServletResponse res,
      final FilterChain chain,
      final Authentication auth) {

    final String token = JWT.create()
        .withSubject(((User) auth.getPrincipal()).getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .sign(HMAC512(SECRET.getBytes()));

    res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
  }
}
