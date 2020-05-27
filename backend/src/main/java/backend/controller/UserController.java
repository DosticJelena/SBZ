package backend.controller;

import backend.model.UserModel;
import backend.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/login", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(@RequestBody UserModel user){
        if(userService.findByUsername(user.getUsername()) == null) {
            throw new RuntimeException("This username does not exist!");
        }else{
            UserModel tempUser = userService.findByUsername(user.getUsername());
            if(user.getPassword().equals(tempUser.getPassword())){
                return ResponseEntity.ok(tempUser.getId());
            }else{
                throw new RuntimeException("Incorrect password!");
            }
        }
    }

    @PostMapping(value="/register", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody UserModel user){
        if(userService.findByUsername(user.getUsername()) != null){
            throw new RuntimeException("Username already exists!");
        }else{
            userService.save(user);
            return ResponseEntity.ok("Account registered");
        }
    }

}
