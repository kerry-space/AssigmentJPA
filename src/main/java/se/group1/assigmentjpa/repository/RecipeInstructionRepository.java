


package se.group1.assigmentjpa.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.group1.assigmentjpa.entity.RecipeInstruction;

@Repository
public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
    @Modifying
    @Query("update RecipeInstruction r set r.instructions = :instructions where r.id = :id")
    int update_instructions(@Param("id")  int id, @Param("instructions") String instructions);
}




