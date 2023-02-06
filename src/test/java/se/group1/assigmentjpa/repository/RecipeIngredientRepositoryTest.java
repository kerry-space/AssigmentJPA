package se.group1.assigmentjpa.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.group1.assigmentjpa.entity.Ingredient;
import se.group1.assigmentjpa.entity.Measurement;
import se.group1.assigmentjpa.entity.RecipeCategory;
import se.group1.assigmentjpa.entity.RecipeIngredient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeIngredientRepositoryTest {
    // allow us to inject beans using @Autowired.
    @Autowired
    RecipeIngredientRepository testObject;

    RecipeIngredient createdRecipeIngredient;


    @BeforeEach
    void setup(){
        Ingredient ingredient = new Ingredient("apple");
       RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient, 100.0, Measurement.HG);
      createdRecipeIngredient = testObject.save(recipeIngredient);

       assertNotNull(createdRecipeIngredient);
    }


    //CRUD TEST methods

    //Create(C)
    @Test
    public void test_created(){
        Ingredient ingredient = new Ingredient("flower");
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient, 100.0, Measurement.HG);
        RecipeIngredient actual = testObject.save(recipeIngredient);
        RecipeIngredient expected = recipeIngredient;

        assertEquals(expected, actual);
    }

    //Read(R)
    @Test
    public void test_findById(){
        Optional<RecipeIngredient> optionalRecipeIngredient = testObject.findById(createdRecipeIngredient.getId());
        assertTrue(optionalRecipeIngredient.isPresent());
        RecipeIngredient actual = optionalRecipeIngredient.get();
        RecipeIngredient expected = createdRecipeIngredient;
        assertEquals(expected,actual);

    }

    //update(U)
    @Test
    public void test_update(){
       
        RecipeIngredient expected = createdRecipeIngredient;

       Optional<RecipeIngredient> optionalRecipeIngredient = testObject.findById(createdRecipeIngredient.getId());
        assertTrue(optionalRecipeIngredient.isPresent());

        Ingredient ingredient = new Ingredient("flower");
        optionalRecipeIngredient.get().setIngredient(ingredient);

        RecipeIngredient actual = testObject.save(optionalRecipeIngredient.get());

        assertEquals(expected, actual);
    }

    //Delete(D)
    @Test
    public void test_delete(){
        testObject.delete(createdRecipeIngredient);
        long actual = 0;
        long expected = testObject.count();

        assertEquals(expected, actual);
    }


}
