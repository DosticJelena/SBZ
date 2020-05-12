package backend.model;

import javax.persistence.*;

@Entity
public class Macronutrients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="macros_id", nullable = false, unique = true)
    private long id;

    @Column
    private double protein;

    @Column
    private double carbs;

    @Column
    private double fat;

    @Column
    private double calories;

    @Column
    private Recipe recipe;

    public Macronutrients() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Macronutrients{" +
                "protein=" + protein +
                ", carbs=" + carbs +
                ", fat=" + fat +
                ", calories=" + calories +
                '}';
    }
}
