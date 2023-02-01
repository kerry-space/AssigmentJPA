package se.group1.assigmentjpa.Repository;

import org.springframework.data.repository.CrudRepository;
import se.group1.assigmentjpa.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

    Optional<Ingredient> findByIngredientName(String ingredientName);

    List<Ingredient> findAllByIngredientNameContainsIgnoreCase(String ingredientName);
}
