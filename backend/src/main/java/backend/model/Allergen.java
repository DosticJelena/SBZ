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
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "userAllergens", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserModel> users;

    @ManyToMany(mappedBy = "allergens", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

}
