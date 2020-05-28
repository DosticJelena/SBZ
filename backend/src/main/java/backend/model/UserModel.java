package backend.model;


import backend.model.enumeration.Gender;
import backend.model.enumeration.WeightGoal;
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
    private int age;

    @Column
    private double weight;

    @Column
    private double height;

    @Column
    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "allergen_user",
            joinColumns = @JoinColumn(name = "allergen_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Allergen> userAllergens;

    @Column
    private double caloriesThreshold;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "macros_id", referencedColumnName = "id")
    private Macronutrients macros;

    @Column
    private WeightGoal weightGoal;

}
