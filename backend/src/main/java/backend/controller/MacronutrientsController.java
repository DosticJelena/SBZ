package backend.controller;

import backend.service.serviceInterface.MacronutrientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("macronutrients")
public class MacronutrientsController {

    @Autowired
    private MacronutrientsService macronutrientsService;

}
