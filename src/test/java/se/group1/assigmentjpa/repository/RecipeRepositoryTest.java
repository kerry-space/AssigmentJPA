package se.group1.assigmentjpa.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.group1.assigmentjpa.entity.*;

import java.util.*;

@DataJpaTest
public class RecipeRepositoryTest {

    // allow us to inject beans using @Autowired.
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


        Recipe recipe = new Recipe("Pancake", recipeIngredientList, recipeInstruction,recipeCategorySet );
        createdRecipe = testObject.save(recipe);
        assertNotNull(createdRecipe);
    }

    //CRUD TEST methods

    //Create(C)
    @Test
    public void test_created(){
        Ingredient ingredient1 = new Ingredient("test one");
        Ingredient ingredient2 = new Ingredient("test two");

        RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredient1, 200.0, Measurement.HG);
        RecipeIngredient recipeIngredient2 = new RecipeIngredient(ingredient2, 200.0, Measurement.KG);

        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
        recipeIngredientList.add(recipeIngredient1);
        recipeIngredientList.add(recipeIngredient2);

        RecipeInstruction recipeInstruction = new RecipeInstruction("test etst test.");


        RecipeCategory recipeCategory1 = new RecipeCategory("one one tyest");
        RecipeCategory recipeCategory2 = new RecipeCategory("two test");

        Set<RecipeCategory> recipeCategorySet = new HashSet<>();
        recipeCategorySet.add(recipeCategory1);
        recipeCategorySet.add(recipeCategory2);


        Recipe recipe = new Recipe("apple", recipeIngredientList, recipeInstruction,recipeCategorySet );
         Recipe expected = testObject.save(recipe);
         Recipe actual = recipe;

         assertEquals(expected, actual);
    }


    @Test
    public void  test_findById(){
       Optional<Recipe>  optionalRecipe = testObject.findById(createdRecipe.getId());
        assertTrue(optionalRecipe.isPresent());
        Recipe actual = optionalRecipe.get();
        Recipe expected = createdRecipe;

        assertEquals(expected, actual);

    }

    @Test
    public void  test_update(){
        Ingredient ingredient1 = new Ingredient("TEST ");
        Ingredient ingredient2 = new Ingredient("TEST");

        RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredient1, 200.0, Measurement.HG);
        RecipeIngredient recipeIngredient2 = new RecipeIngredient(ingredient2, 200.0, Measurement.HG);

        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
        recipeIngredientList.add(recipeIngredient1);
        recipeIngredientList.add(recipeIngredient2);

        RecipeInstruction recipeInstruction = new RecipeInstruction("test testet ste.");


        RecipeCategory recipeCategory1 = new RecipeCategory("testt11111111");
        RecipeCategory recipeCategory2 = new RecipeCategory("test2222222222");

        Set<RecipeCategory> recipeCategorySet = new HashSet<>();
        recipeCategorySet.add(recipeCategory1);
        recipeCategorySet.add(recipeCategory2);


        Recipe recipe = new Recipe("oneTest", recipeIngredientList, recipeInstruction,recipeCategorySet );
        testObject.update_t(
                createdRecipe.getId(),
                recipeIngredientList
                );

        Optional<Recipe> optionalRecipe = testObject.findById(createdRecipe.getId());
        assertTrue(optionalRecipe.isPresent());
        Recipe actual = optionalRecipe.get();
        Recipe expected = recipe;

        assertNotEquals(expected,actual);
    }


    @Test
    public void test_delete() {
        testObject.delete(createdRecipe);
        long actual = 0;
        long expected = testObject.count();

        assertEquals(expected, actual);


    }

}
