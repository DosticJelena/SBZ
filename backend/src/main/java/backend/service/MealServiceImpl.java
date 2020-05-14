package backend.service;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.Meal;
import backend.model.Recipe;
import backend.repository.MealRepository;
import backend.repository.RecipeRepository;
import backend.service.serviceInterface.MealService;
import backend.service.serviceInterface.RecipeService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Meal findById(long id){
        return mealRepository.findById(id);
    }

    @Override
    public Meal findByUser(long id){
        return mealRepository.findByUser(id);
    }

    @Override
    public Meal findByRecipe(long id){
        return mealRepository.findByRecipe(id);
    }

    @Override
    public List<Meal> findAll(){
        return mealRepository.findAll();
    }

    @Override
    public Meal save(Meal meal){
        KieContainer kc = KnowledgeSessionHelper.createRuleBase();
        KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "meals-rules");

        long maxTimesEaten = 0;
        for(Recipe r: recipeRepository.findAll()){
            if(maxTimesEaten < r.getTimesEaten()){
                maxTimesEaten = r.getTimesEaten();
            }
        }

        kSession.setGlobal("maxTimesEaten", maxTimesEaten);

        kSession.getAgenda().getAgendaGroup("eatenMeals").setFocus();

        kSession.insert(meal);
        kSession.fireAllRules();

        return mealRepository.save(meal);
    }

    @Override
    public void deleteById(long id){
        mealRepository.deleteById(id);
    }

}
