package bg.mobile.users.service;

import bg.mobile.users.model.UserModel;

public interface UserService {

  UserModel registerUser(UserModel model);

  UserModel loginUser(String username, String password);

}
