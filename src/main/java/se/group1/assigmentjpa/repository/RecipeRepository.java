package se.group1.assigmentjpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.Recipe;
import se.group1.assigmentjpa.entity.RecipeIngredient;
import se.group1.assigmentjpa.entity.RecipeInstruction;

import java.util.List;
import java.util.Optional;
import java.util.Set;



public interface RecipeRepository extends CrudRepository<Recipe, Integer>
{
    //Read
    Optional<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName);

    @Query("select r from Recipe r where r.categories = :recipeCategory")
    Set<Recipe> findAllByCategoriesIsContainingIgnoreCase(@Param("recipeCategory") String recipeName );
    @Query("select r from Recipe r where r.recipeName = :recipeName")
    Set<Recipe> findAllByCategoriesIgnoreCase(@Param("recipeName") String recipeName);


    //Update
    @Modifying
    @Query("update Recipe i set i.recipeName = :recipeName where i.id = :id")
    void update(@Param("id") int id, @Param("recipeName") String recipeName);

    @Modifying
    @Query("update Recipe i set i.recipeIngredients = :recipeIngredient where i.id = :id")
    void update_t(@Param("id") int id, @Param("recipeIngredient") List<RecipeIngredient> recipeIngredients);

    //i.categories = :categories , i.instruction = :instruction where i.id = :id"
    //, @Param("categories") List<RecipeIngredient> categories,  @Param("instruction") RecipeInstruction instruction
}