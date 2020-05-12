package backend.repository;

import backend.model.Macronutrients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface MacronutrientsRepository extends JpaRepository<Macronutrients, Long> {

        Macronutrients findById(long id);
        List<Macronutrients> findAll();

        Macronutrients save(Macronutrients macronutrients);

        @Modifying
        void deleteById(long id);
}
