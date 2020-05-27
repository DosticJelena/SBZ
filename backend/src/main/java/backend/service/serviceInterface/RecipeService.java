package backend.service.serviceInterface;

import backend.dto.FoundRecipeListsDTO;
import backend.dto.SearchParametersDTO;
import backend.model.Allergen;
import backend.model.Ingredient;
import backend.model.Location;
import backend.model.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe findById(long id);
    Recipe findByName(String name);
    List<Recipe> findAll();

    Recipe save(Recipe recipe);

    void deleteById(long id);

    FoundRecipeListsDTO searchSpecific(List<String> ings, List<String> als, String loc);
}
