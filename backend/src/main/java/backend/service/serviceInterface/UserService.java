package backend.service.serviceInterface;

import backend.model.DailyStatus;
import backend.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel findById(long id);
    UserModel findByUsername(String username);
    List<UserModel> findAll();
    List<DailyStatus> findAllDailyStatuses(long id);

    UserModel save(UserModel userModel);

    void deleteById(long id);
}
