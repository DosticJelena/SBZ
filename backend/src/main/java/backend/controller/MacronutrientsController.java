package backend.controller;

import backend.repository.UserRepository;
import backend.service.serviceInterface.MacronutrientsService;
import backend.model.Macronutrients;
import backend.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("macronutrients")
public class MacronutrientsController {

    @Autowired
    private MacronutrientsService macronutrientsService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserMacros(@PathVariable("userId") long userId){
        backend.model.Macronutrients macros = userService.findById(userId).getMacros();
        System.out.println("macros");
        return ResponseEntity.ok(macros);
    }

}
