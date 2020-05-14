package backend.controller;

import backend.model.Ingredient;
import backend.model.Meal;
import backend.service.serviceInterface.IngredientService;
import backend.service.serviceInterface.MealService;
import backend.service.serviceInterface.RecipeService;
import backend.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value="", produces = APPLICATION_JSON_VALUE)
    public String testSave(){

        Meal meal = new Meal();
        meal.setUser(userService.findById(1));
        meal.setRecipe(recipeService.findById(1));
        meal = mealService.save(meal);
        return meal.getMealTime().toString();
    }
}
