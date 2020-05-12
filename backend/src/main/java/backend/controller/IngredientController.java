package backend.controller;

import backend.model.Ingredient;
import backend.service.serviceInterface.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.enterprise.inject.Produces;
import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping(value="", produces = APPLICATION_JSON_VALUE)
    public List<Ingredient> getAll(){
        return ingredientService.getAll();
    }
}
