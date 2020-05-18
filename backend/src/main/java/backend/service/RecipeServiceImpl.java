package backend.service;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.Recipe;
import backend.repository.RecipeRepository;
import backend.service.serviceInterface.RecipeService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe findById(long id){
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe findByName(String name){
        return recipeRepository.findByName(name);
    }

    @Override
    public List<Recipe> findAll(){
        KieContainer kc = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "meals-rules");

        List<Recipe> recipes = recipeRepository.findAll();

        for (Recipe r : recipes){
            kSession.insert(r);
        }

        kSession.getAgenda().getAgendaGroup("recipeSearchResults").setFocus();
        kSession.fireAllRules();

        for (Recipe r : recipes){
            recipeRepository.save(r);
        }

        return recipeRepository.findAll();
    }

    @Override
    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(long id){
        recipeRepository.deleteById(id);
    }

}
