


package se.group1.assigmentjpa.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.RecipeInstruction;

@Repository
public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}




