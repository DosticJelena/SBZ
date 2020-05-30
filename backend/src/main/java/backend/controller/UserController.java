package backend.controller;

import backend.dto.LoginDTO;
import backend.dto.RegisterDTO;
import backend.model.DailyStatus;
import backend.model.UserModel;
import backend.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/login", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO user){
        if(userService.findByUsername(user.getUsername()) == null) {
            return ResponseEntity.badRequest().body("This username does not exist!");
        }else{
            UserModel tempUser = userService.findByUsername(user.getUsername());
            if(user.getPassword().equals(tempUser.getPassword())){
                return ResponseEntity.ok(tempUser);
            }else{
                return ResponseEntity.badRequest().body("Incorrect password!");
            }
        }
    }

    @PostMapping(value="/register", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO user){
        if(userService.findByUsername(user.getUsername()) != null){
            return ResponseEntity.badRequest().body("Username already exists!");
        }else{
            userService.save(user.mapToModel());
            return ResponseEntity.ok("Account registered");
        }
    }

    @GetMapping(value="/{id}", produces= APPLICATION_JSON_VALUE)
    public UserModel getUserById(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @GetMapping(value="/users-daily-statuses/{id}", produces= APPLICATION_JSON_VALUE)
    private List<DailyStatus> getUsersDailyStatuses(@PathVariable("id") long id){
        return userService.findAllDailyStatuses(id);
    }

}
