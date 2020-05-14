package backend.repository;

import backend.model.Meal;
import backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

        Meal findById(long id);
        Meal findByUser(long user);
        Meal findByRecipe(long recipe);
        List<Meal> findAll();

        Meal save(Meal meal);

        @Modifying
        void deleteById(long id);
}
