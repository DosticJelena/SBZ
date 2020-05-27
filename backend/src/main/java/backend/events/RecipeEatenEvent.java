package backend.events;


import backend.model.Recipe;
import backend.model.UserModel;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.util.Date;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("10m")
public class RecipeEatenEvent {
    private static final long serialVersionUID = 1L;

    private Date executionTime;
    private Recipe recipe;
    private UserModel user;

    public RecipeEatenEvent(Date executionTime, Recipe recipe, UserModel user) {
        this.executionTime = executionTime;
        this.recipe = recipe;
        this.user = user;
    }

    public RecipeEatenEvent() {
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
