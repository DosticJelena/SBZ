package backend.repository;

import backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

        Location findById(long id);
        Location findByName(String name);
        List<Location> findAll();

        Location save(Location location);

        @Modifying
        void deleteById(long id);
}
