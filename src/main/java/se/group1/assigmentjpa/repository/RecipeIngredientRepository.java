package se.group1.assigmentjpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.group1.assigmentjpa.entity.RecipeIngredient;

public interface RecipeIngredientRepository  extends CrudRepository<RecipeIngredient, String> {
}