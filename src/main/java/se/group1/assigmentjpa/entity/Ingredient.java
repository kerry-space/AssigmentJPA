package se.group1.assigmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)

    private String ingredientName;


    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;

    }
}
