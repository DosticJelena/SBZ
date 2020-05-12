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
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable=false, unique=true)
    private long id;

    @Column(nullable=false, unique = true)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column
    private double weight;

    @Column
    private double height;

    @Column
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "recipe_user",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Recipe> userRecipes;

    @ManyToMany
    @JoinTable(
            name = "allergen_user",
            joinColumns = @JoinColumn(name = "allergen_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Allergen> userAllergens;

}
