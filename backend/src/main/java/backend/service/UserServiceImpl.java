package backend.service;

import backend.model.UserModel;
import backend.repository.UserRepository;
import backend.service.serviceInterface.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel findById(long id){
        return userRepository.findById(id);
    }

    @Override
    public UserModel findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    @Override
    public void deleteById(long id){
        userRepository.deleteById(id);
    }

}
