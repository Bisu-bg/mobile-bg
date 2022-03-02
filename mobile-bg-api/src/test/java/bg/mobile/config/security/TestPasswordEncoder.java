package bg.mobile.config.security;

import bg.mobile.base.BaseTest;
import org.junit.jupiter.api.Test;

import static bg.mobile.config.security.PasswordEncoder.checkPassword;
import static bg.mobile.config.security.PasswordEncoder.hashPassword;

public class TestPasswordEncoder extends BaseTest {

  @Test
  public void testPasswordEncoder() {
    String password = "abcdefghijklmnopqrstuvwxyz";
    String hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";

    System.out.println("Testing BCrypt Password hashing and verification");
    System.out.println("Test password: " + password);
    System.out.println("Test stored hash: " + hash);
    System.out.println("Hashing test password...");
    System.out.println();

    String computedHash = hashPassword(password);
    System.out.println("Test computed hash: " + computedHash);
    System.out.println();
    System.out.println("Verifying that hash and stored hash both match for the test password...");
    System.out.println();

    String compareTest = checkPassword(password, hash)
        ? "Passwords Match" : "Passwords do not match";
    String compareComputed = checkPassword(password, computedHash)
        ? "Passwords Match" : "Passwords do not match";

    System.out.println("Verify against stored hash:   " + compareTest);
    System.out.println("Verify against computed hash: " + compareComputed);
  }
}