package backend.service;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.DailyStatus;
import backend.model.Meal;
import backend.model.Recipe;
import backend.model.UserModel;
import backend.repository.MealRepository;
import backend.repository.RecipeRepository;
import backend.repository.UserRepository;
import backend.service.serviceInterface.MealService;
import backend.service.serviceInterface.RecipeService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

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

        double maxTimesEaten = 1.0;
        for(Recipe r: recipeRepository.findAll()){
            if(maxTimesEaten < r.getTimesEaten()){
                maxTimesEaten = r.getTimesEaten();
            }
        }

        kSession.setGlobal("maxTimesEaten", maxTimesEaten);

        kSession.getAgenda().getAgendaGroup("eatenMeals").setFocus();

        kSession.insert(meal);
        kSession.fireAllRules();

        UserModel user = userRepository.findById(meal.getUser().getId());
        for(DailyStatus ds : user.getDailyStatuses()){
            Timestamp tms = new Timestamp(System.currentTimeMillis());
            if(ds.getDate().equals(tms.toLocalDateTime().toLocalDate())){
                ds.getMacros().setCalories(meal.getRecipe().getMacros().getCalories()+ds.getMacros().getCalories());
                ds.getMacros().setCarbs(meal.getRecipe().getMacros().getCarbs()+ds.getMacros().getCarbs());
                ds.getMacros().setProtein(meal.getRecipe().getMacros().getProtein()+ds.getMacros().getProtein());
                ds.getMacros().setFat(meal.getRecipe().getMacros().getFat()+ds.getMacros().getFat());
                userRepository.save(user);
                break;
            }
        }

        mealRepository.save(meal);
        if(meal.getRecipe().getTimesEaten() >= maxTimesEaten){
            maxTimesEaten = meal.getRecipe().getTimesEaten();
            kSession.setGlobal("maxTimesEaten", maxTimesEaten);

            kSession.getAgenda().getAgendaGroup("popularRecipe").setFocus();

            List<Recipe> recipeList = recipeRepository.findAll();
            for(Recipe r: recipeList){
                kSession.insert(r);
            }

            kSession.fireAllRules();

            for(Recipe r : recipeList) {
                recipeRepository.save(r);
            }
        }
        return meal;

    }

    @Override
    public void deleteById(long id){
        mealRepository.deleteById(id);
    }

}
