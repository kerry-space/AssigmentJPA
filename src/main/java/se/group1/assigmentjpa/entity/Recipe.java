package se.group1.assigmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.group1.assigmentjpa.exception.DataDuplicateException;
import se.group1.assigmentjpa.exception.DataNotFoundException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( nullable = false)
    private String recipeName;

    @OneToMany(
            mappedBy = "recipe",//must be mappedBy dame entity on RecipeIngredient recipe
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipe_RecipeCategory",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "RecipeCategory_id")
    )
    private Set<RecipeCategory>categories = new HashSet<>();


    public Recipe( String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, Set<RecipeCategory> categories ) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }



    //helper methods
    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        if(recipeIngredients.contains(recipeIngredient)){
            throw new DataDuplicateException("Data duplicate exception");
        }
        recipeIngredients.add(recipeIngredient);
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if(!recipeIngredients.contains(recipeIngredient)){
            throw new DataNotFoundException("Data not found exception");
        }
        recipeIngredients.remove(recipeIngredient);
    }


    public void addRecipeCategory(RecipeCategory recipeCategory){
        if(categories.contains(recipeCategory)){
            throw new DataDuplicateException("Data duplicate exceptions");
        }
        categories.add(recipeCategory);
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory){
        if(!categories.contains(recipeCategory)){
            throw new DataNotFoundException("Data not found");
        }
        categories.remove(recipeCategory);
    }
}
