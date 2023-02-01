package se.group1.assigmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private int id;

    private Ingredient ingredient;

    private  Double amount;

    private Measurement measurement;

    private Recipe recipe;


}
