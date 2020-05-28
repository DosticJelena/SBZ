package backend.service;

import backend.dto.FoundRecipeListsDTO;
import backend.dto.SearchParametersDTO;
import backend.kie.util.KnowledgeSessionHelper;
import backend.model.Allergen;
import backend.model.Ingredient;
import backend.model.Location;
import backend.model.Recipe;
import backend.repository.AllergenRepository;
import backend.repository.IngredientRepository;
import backend.repository.LocationRepository;
import backend.repository.RecipeRepository;
import backend.service.serviceInterface.RecipeService;
import org.kie.api.definition.rule.All;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private AllergenRepository allergenRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private LocationRepository locationRepository;

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

    @Override
    public FoundRecipeListsDTO searchSpecific(List<String> ings, List<String> als, String loc){

        List<Recipe> recipeList = recipeRepository.findAll();
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        List<Allergen> allergens = new ArrayList<Allergen>();
        Location location = new Location();
        if(loc != null){
            location = locationRepository.findByName(loc);
        }

        for(String ingName : ings){
            ingredients.add(ingredientRepository.findByName(ingName));
        }

        for(String alName : als){
            allergens.add(allergenRepository.findByName(alName));
        }

        List<Recipe> validRecipes = new ArrayList<Recipe>();
        List<Recipe> continentRecipes = new ArrayList<Recipe>();
        List<Recipe> worldwideRecipes = new ArrayList<Recipe>();
        List<Recipe> semiValidRecipes = new ArrayList<Recipe>(); //some ingredients may not be included

        List<Ingredient> allergicIngredients = new ArrayList<Ingredient>();
        for(Allergen al : allergens){
            for(Ingredient ing : al.getIngredients()){
                if(!allergicIngredients.contains(ing)){
                    allergicIngredients.add(ing);
                }
            }
        }
        for(Recipe r : recipeList){
            boolean containsAllIngredients = true;
            int missingIngredients = 0;
            for(Ingredient ing : ingredients){
                if(!r.getIngredients().contains(ing)){
                    containsAllIngredients = false;
                    missingIngredients += 1;
                    break;
                }
            }
            if(containsAllIngredients) {

                boolean noAllergicIngredients = true;
                for (Ingredient aling : allergicIngredients) {
                    if (r.getIngredients().contains(aling)) {
                        noAllergicIngredients = false;
                    }
                }
                if (noAllergicIngredients) {

                    KieContainer kc = KnowledgeSessionHelper.createRuleBase();
                    KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "recipes-rules");

                    kSession.insert(r);

                    kSession.getAgenda().getAgendaGroup("recipeSearchResults").setFocus();
                    kSession.fireAllRules();
                    recipeRepository.save(r);

                    if(r.getLocation().getName().equals(location.getName())) {
                        validRecipes.add(r);
                    } else if(r.getLocation().getContinent().equals(location.getContinent())){
                        continentRecipes.add(r);
                    } else {
                        worldwideRecipes.add(r);
                    }
                }
            }
            if (missingIngredients <= (r.getIngredients().size()/2) && missingIngredients != 0) {

                boolean noAllergicIngredients = true;
                for(Ingredient aling : allergicIngredients){
                    if(r.getIngredients().contains(aling)){
                        noAllergicIngredients = false;
                    }
                }
                if(noAllergicIngredients){
                    semiValidRecipes.add(r);
                }
            }
        }

        FoundRecipeListsDTO finalLists = new FoundRecipeListsDTO();
        finalLists.setValidRecipes(validRecipes);
        finalLists.setContinentRecipes(continentRecipes);
        finalLists.setWorldwideRecipes(worldwideRecipes);
        finalLists.setSemiValidRecipes(semiValidRecipes);

        return finalLists;
    }

}
