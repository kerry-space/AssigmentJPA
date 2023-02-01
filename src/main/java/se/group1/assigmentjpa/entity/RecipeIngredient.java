package se.group1.assigmentjpa.entity;

<<<<<<< HEAD

=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> 0a75288e51287bbb7aaccfec7de7d039758d45a5
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

<<<<<<< HEAD
@Entity

=======
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
>>>>>>> 0a75288e51287bbb7aaccfec7de7d039758d45a5
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
<<<<<<< HEAD
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Ingredient ingredient;

    private double amount;

    // todo : private Measurement measurement

    @ManyToOne(cascade = CascadeType.ALL)
    private Recipe recipe;



=======
    private int id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Ingredient ingredient;

    private  Double amount;

    private Measurement measurement;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Recipe recipe;


>>>>>>> 0a75288e51287bbb7aaccfec7de7d039758d45a5
}
