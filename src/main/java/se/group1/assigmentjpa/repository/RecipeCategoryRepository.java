package se.group1.assigmentjpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.RecipeCategory;



@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {


    @Modifying
    @Query("update RecipeCategory r set r.category = :category where r.id = :id")
    boolean test_updateRecipeCategory(@Param("id") int id, @Param("category") String category);
}
