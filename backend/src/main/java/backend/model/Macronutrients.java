package backend.model;

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

    @OneToOne(mappedBy = "macros")
    private Recipe recipe;

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
