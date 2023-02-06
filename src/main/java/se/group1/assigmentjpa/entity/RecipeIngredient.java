package se.group1.assigmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RecipeIngredient {

    @Id
    //ypu only use for String type
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Ingredient ingredient;

    private  Double amount;

    private Measurement measurement;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Recipe recipe;

    public RecipeIngredient(Ingredient ingredient, Double amount, Measurement measurement) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
    }

    public RecipeIngredient(String id, Ingredient ingredient) {
        this.id = id;
        this.ingredient = ingredient;
    }
}
