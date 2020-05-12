package backend.repository;

import backend.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

        Ingredient findById(long id);
        Ingredient findByName(String name);
        List<Ingredient> findAll();

        Ingredient save(Ingredient ingredient);

        @Modifying
        void deleteById(long id);
}
