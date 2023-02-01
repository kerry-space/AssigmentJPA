package se.group1.assigmentjpa.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.group1.assigmentjpa.entity.Recipe;
import se.group1.assigmentjpa.entity.RecipeInstruction;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}




