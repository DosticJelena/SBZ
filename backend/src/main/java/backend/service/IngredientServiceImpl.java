package backend.service;

import backend.model.Allergen;
import backend.model.Ingredient;
import backend.repository.IngredientRepository;
import backend.service.serviceInterface.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient findById(long id){
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient findByName(String name){
        return ingredientRepository.findByName(name);
    }

    @Override
    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteById(long id){
        ingredientRepository.deleteById(id);
    }
}
