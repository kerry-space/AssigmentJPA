package se.group1.assigmentjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.RecipeCategory;

@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
}
