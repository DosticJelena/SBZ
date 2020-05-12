package backend.controller;

import backend.service.serviceInterface.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("location")
public class LocationController {

    @Autowired
    private LocationService locationService;

}
