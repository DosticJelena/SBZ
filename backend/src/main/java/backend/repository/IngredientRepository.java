package backend.repository;

import backend.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

        Ingredient findById(long id);
        List<Ingredient> findAll();
}
