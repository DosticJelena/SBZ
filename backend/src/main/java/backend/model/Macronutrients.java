package backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Macronutrients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private long id;

    @Column
    private double protein;

    @Column
    private double carbs;

    @Column
    private double fat;

    @Column
    private double calories;

    @JsonIgnore
    @OneToOne(mappedBy = "macros")
    private Recipe recipe;

    @JsonIgnore
    @OneToOne(mappedBy = "macros")
    private UserModel user;

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
