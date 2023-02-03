package se.group1.assigmentjpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.group1.assigmentjpa.entity.Ingredient;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

   Optional<Ingredient> findByIngredientNameContainsIgnoreCase(String ingredientName);

   @Query("update Ingredient i set i.ingredientName = :ingredientName where i.id = :id ")

   void updateIngredientName(@Param("ingredientName") String ingredientName, @Param("id") int id);



}
