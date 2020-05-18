package backend.controller;

import backend.model.Recipe;
import backend.service.serviceInterface.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value="/")
    public List<Recipe> getAllRecipes(){
        return recipeService.findAll();
    }

}
