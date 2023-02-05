package se.group1.assigmentjpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.group1.assigmentjpa.entity.Ingredient;
import se.group1.assigmentjpa.entity.RecipeCategory;

import java.util.Optional;

@DataJpaTest
public class RecipeCategoryRepositoryTest {

    // allow us to inject beans using @Autowired.
    @Autowired
    RecipeCategoryRepository testObject;

    RecipeCategory createdRecipeCategory;

    @BeforeEach
    public  void  setup(){
        RecipeCategory recipeCategory = new RecipeCategory("test cate ");
        createdRecipeCategory = testObject.save(recipeCategory);
        assertNotNull(createdRecipeCategory);
    }



    //CRUD TEST methods

    //Create(C)
    @Test
    public void test_created(){
        RecipeCategory recipeCategory = new RecipeCategory("banan and apple");
        RecipeCategory actual =  testObject.save(recipeCategory);
        RecipeCategory expected = recipeCategory;

        assertEquals(expected, actual);
    }

    //Read(R)
    @Test
    public void test_findById(){
        Optional<RecipeCategory> optionalRecipeCategory = testObject.findById(createdRecipeCategory.getId());
        assertTrue(optionalRecipeCategory.isPresent());
        RecipeCategory actual = optionalRecipeCategory.get();
        RecipeCategory expected = createdRecipeCategory;
        assertEquals(expected,actual);

    }

    //update(U)
    @Test
    public void test_update(){
        Boolean result = testObject.test_updateRecipeCategory(createdRecipeCategory.getId(), "test oneoone");
        assertEquals(true, result);

    }

    //Delete(D)
    @Test
    public void test_delete(){
        testObject.delete(createdRecipeCategory);
        long actual = 0;
        long expected = testObject.count();

        assertEquals(expected, actual);
    }

}
