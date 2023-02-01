package se.group1.assigmentjpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( nullable = false)
    private String category;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipeCategory_recipe",
            joinColumns = @JoinColumn(name = "recipeCategory_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe>recipe = new HashSet<>();

}
