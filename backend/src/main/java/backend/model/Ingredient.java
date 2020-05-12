package backend.model;


import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ingredient_id", nullable = false, unique = true)
    private long id;

    @Column(nullable=false, unique = true)
    private String name;

    //ManyToMany

    public Ingredient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
