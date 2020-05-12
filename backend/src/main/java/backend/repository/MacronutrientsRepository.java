package backend.repository;

import backend.model.Macronutrients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MacronutrientsRepository extends JpaRepository<Macronutrients, Long> {

        Macronutrients findById(long id);
}
