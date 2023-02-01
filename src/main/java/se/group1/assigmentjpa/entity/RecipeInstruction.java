package se.group1.assigmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( nullable = false)
    private String instructions;

}
