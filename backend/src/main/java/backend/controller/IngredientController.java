package backend.controller;

import backend.service.serviceInterface.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

}
