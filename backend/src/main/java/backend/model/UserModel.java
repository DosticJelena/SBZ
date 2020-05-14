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

    enum WeightGoal{
        LOSE,
        MAINTAIN,
        GAIN
    }

    enum Gender {
        FEMALE,
        MALE
    }

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

    @Column
    private WeightGoal weightGoal;

}
