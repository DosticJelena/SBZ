package backend.controller;

import backend.model.Allergen;
import backend.model.Recipe;
import backend.service.serviceInterface.AllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("allergens")
public class AllergenController {

    @Autowired
    private AllergenService allergenService;

    @GetMapping(value="")
    public List<Allergen> getAllRecipes(){
        return allergenService.findAll();
    }

}
