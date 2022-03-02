package bg.mobile.config.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordEncoder {

  private static final int WORKLOAD = 12;

  public static String hashPassword(final String plainTextPassword) {
    final String salt = BCrypt.gensalt(WORKLOAD);

    return BCrypt.hashpw(plainTextPassword, salt);
  }

  public static boolean checkPassword(final String plainTextPassword, final String storedHash) {
    if (null == storedHash || !storedHash.startsWith("$2a$")) {
      throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
    }

    return BCrypt.checkpw(plainTextPassword, storedHash);
  }
}