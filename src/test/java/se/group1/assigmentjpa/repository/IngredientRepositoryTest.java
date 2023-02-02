package se.group1.assigmentjpa.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.group1.assigmentjpa.entity.*;

import java.util.*;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    RecipeRepository testObject;

    Recipe createdRecipe;

    @BeforeEach
    public void setup() {
        Ingredient ingredient1 = new Ingredient("Baking powder");
        Ingredient ingredient2 = new Ingredient("eggs");

        RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredient1, 100.0, Measurement.KG);
        RecipeIngredient recipeIngredient2 = new RecipeIngredient(ingredient2, 100.0, Measurement.KG);

        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
        recipeIngredientList.add(recipeIngredient1);
        recipeIngredientList.add(recipeIngredient2);

        RecipeInstruction recipeInstruction = new RecipeInstruction("putting eggs and baking powder togheter and stir it.");


        RecipeCategory recipeCategory1 = new RecipeCategory("one pancake for morning, one pancake for afternoon");
        RecipeCategory recipeCategory2 = new RecipeCategory("one pancake for morning, one pancake for afternoon");

        Set<RecipeCategory> recipeCategorySet = new HashSet<>();
        recipeCategorySet.add(recipeCategory1);
        recipeCategorySet.add(recipeCategory2);


        createdRecipe = new Recipe("Pancake", recipeIngredientList, recipeInstruction,recipeCategorySet );
        assertNotNull(createdRecipe);
    }


    @Test
    public void  test_findById(){
       Optional<Recipe>  optionalRecipe = testObject.findById(createdRecipe.getId());
        assertTrue(optionalRecipe.isPresent());
        Recipe actual = optionalRecipe.get();
        Recipe expected = createdRecipe;

        assertEquals(expected, actual);

    }


}
