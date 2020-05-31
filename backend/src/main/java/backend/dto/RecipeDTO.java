package backend.dto;

import backend.model.Ingredient;
import backend.model.Location;
import backend.model.Macronutrients;
import backend.model.Recipe;
import backend.model.UserModel;
import backend.model.enumeration.Gender;
import backend.model.enumeration.WeightGoal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private String name;
    private Macronutrients macros;
    private Location location;
    private long timesEaten;
    private long timesViewed;
    private double rating;
    private List<String> ingredients = new ArrayList<String>();

    public RecipeDTO(Recipe r){
        name = r.getName();
        macros = r.getMacros();
        location = r.getLocation();
        timesEaten = r.getTimesEaten();
        timesViewed = r.getTimesViewed();
        rating = r.getRating();
        for(Ingredient ing : r.getIngredients()){
            ingredients.add(ing.getName());
        }
    }

}
