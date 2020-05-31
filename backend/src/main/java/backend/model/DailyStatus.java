package backend.model;


import backend.model.enumeration.GoodBadStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mvel2.Macro;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = true)
    private UserModel user;

    @Column
    private Timestamp date;

    @Column
    private GoodBadStatus status;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "macros_id", referencedColumnName = "id")
    private Macronutrients macros;

    public DailyStatus(Timestamp date){
        this.date = date;
        this.macros = new Macronutrients();
    }

}
