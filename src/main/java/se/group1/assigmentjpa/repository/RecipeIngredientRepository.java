package se.group1.assigmentjpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.group1.assigmentjpa.entity.Ingredient;
import se.group1.assigmentjpa.entity.RecipeIngredient;

public interface RecipeIngredientRepository  extends CrudRepository<RecipeIngredient, String> {

    @Modifying
    @Query("update RecipeIngredient r set r.ingredient = :ingredient where r.id = :id")
    int  update_ingredient(@Param("id") String id, @Param("ingredient")Ingredient ingredient);
}
