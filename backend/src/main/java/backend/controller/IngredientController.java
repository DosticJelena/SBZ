package backend.controller;

import backend.model.Ingredient;
import backend.service.serviceInterface.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping(value="")
    public List<Ingredient> getAll(){
        return ingredientService.getAll();
    }
}
