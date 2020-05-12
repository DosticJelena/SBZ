package backend.repository;

import backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

        Recipe findById(long id);
        Recipe findByName(String name);
        List<Recipe> findAll();

        Recipe save(Recipe recipe);

        @Modifying
        void deleteById(long id);
}
