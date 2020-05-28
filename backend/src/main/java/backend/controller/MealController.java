package backend.controller;

import backend.dto.NewMealDTO;
import backend.model.Ingredient;
import backend.model.Meal;
import backend.service.serviceInterface.IngredientService;
import backend.service.serviceInterface.MealService;
import backend.service.serviceInterface.RecipeService;
import backend.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/add", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMeal(@RequestBody NewMealDTO newMealDTO){

        Meal meal = new Meal();
        meal.setUser(userService.findByUsername(newMealDTO.getUsername()));
        meal.setRecipe(recipeService.findByName(newMealDTO.getRecipeName()));
        meal = mealService.save(meal);
        return ResponseEntity.ok(meal.getMealTime().toString());
    }
}
