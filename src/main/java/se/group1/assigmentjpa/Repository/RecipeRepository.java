package se.group1.assigmentjpa.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.Recipe;



@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    Optional<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName);

    List<Recipe> findAllByRecipeNameContainsIgnoreCase(String recipeName);

    @Query("select a from Recipe a where a.categories = :recipeCategory")
    Set<Recipe> findAllByCategoriesIsContainingIgnoreCase(@Param("recipeCategory") String recipeName );

    @Query("select a from Recipe a where a.recipeName = :recipeName")
    Set<Recipe> findAllByCategoriesIgnoreCase(@Param("recipeName") String recipeName);

}

