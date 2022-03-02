package bg.mobile.users.service;

import bg.mobile.users.model.UserModel;
import bg.mobile.users.rest.LoginResponse;

public interface UserService {

  UserModel registerUser(UserModel model);

  LoginResponse loginUser(String username, String password);
}