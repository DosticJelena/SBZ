package backend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private long id;

    @Column(nullable=false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "recipes")
    private Set<Ingredient> ingredients;

    @ManyToMany(mappedBy = "userRecipes")
    private Set<UserModel> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "macros_id", referencedColumnName = "id")
    private Macronutrients macros;

    public Recipe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
