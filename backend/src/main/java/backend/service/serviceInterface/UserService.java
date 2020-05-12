package backend.service.serviceInterface;

import backend.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel findById(long id);
    UserModel findByUsername(String username);
    List<UserModel> findAll();

    UserModel save(UserModel userModel);

    void deleteById(long id);
}
