package backend.controller;

import backend.service.serviceInterface.AllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("allergens")
public class AllergenController {

    @Autowired
    private AllergenService allergenService;

}
