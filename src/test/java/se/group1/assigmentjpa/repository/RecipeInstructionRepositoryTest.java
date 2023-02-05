package se.group1.assigmentjpa.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.group1.assigmentjpa.entity.Ingredient;
import se.group1.assigmentjpa.entity.RecipeInstruction;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class RecipeInstructionRepositoryTest {

    // allow us to inject beans using @Autowired.
    @Autowired
    RecipeInstructionRepository testObject;

    RecipeInstruction createdRecipeInstruction;

    @BeforeEach
    public void setup() {
        RecipeInstruction recipeInstruction = new RecipeInstruction("test");
        createdRecipeInstruction = testObject.save(recipeInstruction);
        assertNotNull(createdRecipeInstruction);
    }

    //CRUD TEST methods

    //Create(C)
    @Test
    public void test_created() {
        RecipeInstruction recipeInstruction = new RecipeInstruction("test instruction");

        RecipeInstruction expected = testObject.save(recipeInstruction);
        RecipeInstruction actual = recipeInstruction;

        assertEquals(expected, actual);
    }

    //Read(R)
    @Test
    public void test_findById() {
        Optional<RecipeInstruction> optionalIngredient = testObject.findById(createdRecipeInstruction.getId());
        assertTrue(optionalIngredient.isPresent());
        RecipeInstruction actual = optionalIngredient.get();
        RecipeInstruction expected = createdRecipeInstruction;
        assertEquals(expected, actual);

    }

    //update(U)
    @Test
    public void test_update() {
        String newIngredientName = "flower";
        int result = testObject.update_instructions(createdRecipeInstruction.getId(), newIngredientName);
        assertEquals(1, result);

        Optional<RecipeInstruction> optionalRecipeInstruction = testObject.findById(createdRecipeInstruction.getId());
        assertTrue(optionalRecipeInstruction.isPresent());
        RecipeInstruction updatedIngredient = optionalRecipeInstruction.get();

        assertEquals(newIngredientName, updatedIngredient.getInstructions());
    }

    //Delete(D)
    @Test
    public void test_delete() {
        testObject.delete(createdRecipeInstruction);
        long actual = 0;
        long expected = testObject.count();

        assertEquals(expected, actual);


    }
}
