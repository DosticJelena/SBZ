package backend.service.serviceInterface;

import backend.model.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe findById(long id);
    Recipe findByName(String name);
    List<Recipe> findAll();

    Recipe save(Recipe recipe);

    void deleteById(long id);
}
