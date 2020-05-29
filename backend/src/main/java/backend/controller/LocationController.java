package backend.controller;

import backend.model.Location;
import backend.model.Recipe;
import backend.service.serviceInterface.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value="")
    public List<Location> getAll(){
        return locationService.findAll();
    }

}
