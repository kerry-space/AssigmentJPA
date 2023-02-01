package se.group1.assigmentjpa.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity

public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Ingredient ingredient;

    private double amount;

    // todo : private Measurement measurement

    @ManyToOne(cascade = CascadeType.ALL)
    private Recipe recipe;



}
