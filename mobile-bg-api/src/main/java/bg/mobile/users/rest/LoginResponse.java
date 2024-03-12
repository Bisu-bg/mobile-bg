package bg.mobile.users.rest;

import bg.mobile.users.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

  private UserModel user;
  private String jwtToken;
}