package bg.mobile.config.security;

public class SecurityConstants {

  public static final String SECRET = "SecretKeyToGenJWTs";
  public static final long EXPIRATION_TIME = 86400000; // 1 day
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String REGISTER_URL = "/users/register";
  public static final String LOGIN_URL = "/users/login";
}
