package se.group1.assigmentjpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.group1.assigmentjpa.entity.Ingredient;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

   Optional<Ingredient> findByIngredientNameContainsIgnoreCase(String ingredientName);

   //custom CRUD, just as option




   //Read(R)
   @Query("select i from Ingredient  i where i.ingredientName = :ingredientName" )
   Optional<Ingredient> findByIngredientName(@Param("ingredientName") String ingredientName);

   //Update(U)
   @Modifying()
   @Query("update Ingredient i set i.ingredientName = :ingredientName where i.id = :id ")
   int updateIngredientName(@Param("id") int id, @Param("ingredientName") String ingredientName);

   @Modifying()
   @Query("delete Ingredient  i where i.id = :id")
   void deleteById(@Param(("id")) int id);


}
