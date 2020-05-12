package backend.service;

import backend.model.Location;
import backend.repository.LocationRepository;
import backend.service.serviceInterface.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location findById(long id){
        return locationRepository.findById(id);
    }

    @Override
    public Location findByName(String name){
        return locationRepository.findByName(name);
    }

    @Override
    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    @Override
    public Location save(Location location){
        return locationRepository.save(location);
    }

    @Override
    public void deleteById(long id){
        locationRepository.deleteById(id);
    }
}
