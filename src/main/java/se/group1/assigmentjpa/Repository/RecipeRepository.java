package se.group1.assigmentjpa.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
