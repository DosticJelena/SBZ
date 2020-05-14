package backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private long id;

    @Column(nullable=false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "recipes")
    private Set<Ingredient> ingredients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "macros_id", referencedColumnName = "id")
    private Macronutrients macros;

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", macros=" + macros +
                '}';
    }
}
