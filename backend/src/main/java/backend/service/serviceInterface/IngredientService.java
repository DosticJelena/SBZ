package backend.service.serviceInterface;

import backend.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(long id);
    Ingredient findByName(String name);
    List<Ingredient> findAll();

    Ingredient save(Ingredient ingredient);

    void deleteById(long id);
}
