package se.group1.assigmentjpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.group1.assigmentjpa.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

   Optional<Ingredient> findByIngredientNameContainsIgnoreCase(String ingredientName);
}
