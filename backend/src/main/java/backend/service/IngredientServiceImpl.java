package backend.service;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.Allergen;
import backend.model.Ingredient;
import backend.repository.IngredientRepository;
import backend.service.serviceInterface.IngredientService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
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
        KieContainer kc = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "ksession-rules");

        List<Ingredient> list = ingredientRepository.findAll();
        kSession.insert(list.get(0));
        kSession.fireAllRules();

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
