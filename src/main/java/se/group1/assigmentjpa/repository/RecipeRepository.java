package se.group1.assigmentjpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.Recipe;
import java.util.List;
import java.util.Optional;
import java.util.Set;



public interface RecipeRepository extends CrudRepository<Recipe, Integer>
{    Optional<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName);
    List<Recipe> findAllByRecipeNameContainsIgnoreCase(String recipeName);
    @Query("select r from Recipe r where r.categories = :recipeCategory")
    Set<Recipe> findAllByCategoriesIsContainingIgnoreCase(@Param("recipeCategory") String recipeName );
    @Query("select r from Recipe r where r.recipeName = :recipeName")
    Set<Recipe> findAllByCategoriesIgnoreCase(@Param("recipeName") String recipeName);}