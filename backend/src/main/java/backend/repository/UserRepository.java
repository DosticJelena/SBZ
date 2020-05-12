package backend.repository;

import backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {

        UserModel findById(long id);
        UserModel findByUsername(String username);
        List<UserModel> findAll();

        UserModel save(UserModel userModel);

        @Modifying
        void deleteById(long id);
}
