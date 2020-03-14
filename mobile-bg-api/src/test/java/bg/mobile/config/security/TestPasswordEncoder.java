package bg.mobile.config.security;

import static bg.mobile.config.security.PasswordEncoder.checkPassword;
import static bg.mobile.config.security.PasswordEncoder.hashPassword;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestPasswordEncoder {

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
