package se.group1.assigmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(unique = true )
    private String ingredientName;


    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
