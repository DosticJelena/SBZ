package backend.service.serviceInterface;

import backend.model.Location;

import java.util.List;

public interface LocationService {
    Location findById(long id);
    Location findByName(String name);
    List<Location> findAll();

    Location save(Location location);

    void deleteById(long id);
}
