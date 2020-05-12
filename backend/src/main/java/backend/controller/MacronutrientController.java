package backend.controller;

import backend.service.serviceInterface.MacronutrientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MacronutrientController {

    @Autowired
    private MacronutrientsService macronutrientsService;

}
