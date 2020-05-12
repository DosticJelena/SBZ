package backend.repository;

import backend.model.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergenRepository extends JpaRepository<Allergen, Long> {

        Allergen findById(long id);
}
