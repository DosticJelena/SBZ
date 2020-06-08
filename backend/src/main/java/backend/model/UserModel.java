package backend.model;


import backend.model.enumeration.Gender;
import backend.model.enumeration.GoodBadStatus;
import backend.model.enumeration.WeightGoal;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Allergen> userAllergens;

    @Column
    private double caloriesThreshold;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "macros_id", referencedColumnName = "id")
    private Macronutrients macros;

    @Column
    private WeightGoal weightGoal;

    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DailyStatus> dailyStatuses;

    public void updateDailyStatus(long id, GoodBadStatus status) {
        for(DailyStatus ds : this.dailyStatuses){
            if (ds.getId() == id){
                ds.setStatus(status);
            }
        }
    }

}
