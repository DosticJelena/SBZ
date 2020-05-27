package backend.dto;

import backend.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoundRecipeListsDTO {
    private List<Recipe> validRecipes;
    private List<Recipe> continentRecipes;
    private List<Recipe> worldwideRecipes;
    private List<Recipe> semiValidRecipes;

}
