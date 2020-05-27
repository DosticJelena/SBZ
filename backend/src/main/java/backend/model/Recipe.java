package backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    
    public enum Popularity{
        LOW,
        MEDIUM,
        HIGH
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private long id;

    @Column(nullable=false, unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "recipes")
    private Set<Ingredient> ingredients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "macros_id", referencedColumnName = "id")
    private Macronutrients macros;

    @Column
    private long timesEaten;

    @Column
    private long timesViewed;

    @Column
    private double rating;

    @Column
    private Popularity popularity;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="location", referencedColumnName = "location_id", nullable = true)
    private Location location;


    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", macros=" + macros +
                '}';
    }
}
