package se.group1.assigmentjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.group1.assigmentjpa.exception.DataDuplicateException;
import se.group1.assigmentjpa.exception.DataNotFoundException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( nullable = false)
    private String category;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipe_RecipeCategory",
            joinColumns = @JoinColumn(name = "recipeCategory_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe>recipes = new HashSet<>();


    public RecipeCategory(String category) {
        this.category = category;
    }



    //helper methods
    public void addRecipe(Recipe recipe){
        if(recipes.contains(recipe)){
            throw new DataDuplicateException("Data duplicate exceptions");
        }
      recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe){
        if(!recipes.contains(recipe)){
            throw new DataNotFoundException("Data not found");
        }
        recipes.remove(recipe);
    }

}
