package backend.repository;

import backend.model.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface AllergenRepository extends JpaRepository<Allergen, Long> {

        Allergen findById(long id);
        Allergen findByName(String name);

        List<Allergen> findAll();

        Allergen save(Allergen allergen);

        @Modifying
        void deleteById(long id);
}
