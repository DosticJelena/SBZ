package backend.model;

public class Recipe {

    private String name;
    private Set<Ingredient> ingredients;
    private Macronutrients macros;

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Macronutrients getMacros() {
        return macros;
    }

    public void setMacros(Macronutrients macros) {
        this.macros = macros;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", macros=" + macros +
                '}';
    }
}
