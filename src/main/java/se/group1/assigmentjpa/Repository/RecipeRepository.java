package se.group1.assigmentjpa.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Optional<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName);

    List<Recipe> findAllByRecipeNameContainsIgnoreCase(String recipeName);
}
