package backend.service.serviceInterface;

import backend.model.Meal;
import backend.model.Recipe;

import java.util.List;

public interface MealService {
    Meal findById(long id);
    Meal findByUser(long user);
    Meal findByRecipe(long recipe);
    List<Meal> findAll();

    Meal save(Meal meal);

    void deleteById(long id);
}
