package backend.controller;

import backend.dto.RecipeDTO;
import backend.dto.SearchParametersDTO;
import backend.model.Allergen;
import backend.model.Ingredient;
import backend.model.Recipe;
import backend.service.serviceInterface.AllergenService;
import backend.service.serviceInterface.IngredientService;
import backend.service.serviceInterface.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value="")
    public List<Recipe> getAllRecipes(){
        return recipeService.findAll();
    }

    @GetMapping(value="/{id}", consumes = APPLICATION_JSON_VALUE)
    public RecipeDTO getById(@PathVariable String id){
        RecipeDTO rdto = new RecipeDTO(recipeService.findById(Long.valueOf(id)));
        return rdto;
    }

    @PostMapping(value="/search", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchForRecipes(@RequestBody SearchParametersDTO searchParams){
        return ResponseEntity.ok(recipeService.searchSpecific(searchParams.getIngredients(),
                searchParams.getAllergens(), searchParams.getLocation()));
    }

}
