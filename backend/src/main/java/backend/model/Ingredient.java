package backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private long id;

    @Column(nullable=false, unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "ingredient_recipe",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Recipe> recipes;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="ingredient_allergen", joinColumns = @JoinColumn(name="ingredient_id"),
            inverseJoinColumns = @JoinColumn(name="allergen_id"))
    private Set<Allergen> allergens;

}
