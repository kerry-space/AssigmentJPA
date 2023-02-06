package se.group1.assigmentjpa.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.group1.assigmentjpa.entity.Ingredient;

import java.util.Optional;

@DataJpaTest
public class IngredientRepositoryTest {

    // allow us to inject beans using @Autowired.
    @Autowired
    IngredientRepository testObject;

    Ingredient createdIngredient;

    @BeforeEach
    public void setup(){
         Ingredient ingredient = new Ingredient("test");
         createdIngredient = testObject.save(ingredient);
         assertNotNull(createdIngredient);
    }

    //CRUD TEST methods

    //Create(C)
    @Test
    public void test_created(){
        Ingredient ingredient = new Ingredient("choload");
        Ingredient actual =  testObject.save(ingredient);
        Ingredient expected = ingredient;

        assertEquals(expected, actual);
    }

    //Read(R)
    @Test
    public void test_findById(){
      Optional<Ingredient> optionalIngredient = testObject.findById(createdIngredient.getId());
      assertTrue(optionalIngredient.isPresent());
      Ingredient actual = optionalIngredient.get();
      Ingredient expected = createdIngredient;
      assertEquals(expected,actual);

    }

    //update(U)
    @Test
    public void test_update(){
        //step1: expected result
       Ingredient expected = new Ingredient(createdIngredient.getId(), "Flower");

       //step2: findById(createdIngredient)
       Optional<Ingredient> optionalIngredient = testObject.findById(createdIngredient.getId());
       assertTrue(optionalIngredient.isPresent());

       //finds, gets the Ingredient
       optionalIngredient.get().setIngredientName("Flower");

       //set the Ingredient
       Ingredient actual = testObject.save(optionalIngredient.get());

       //step3: compare them
       assertEquals(expected, actual);
    }

    //Delete(D)
    @Test
    public void test_delete(){
        testObject.delete(createdIngredient);
        long actual = 0;
        long expected = testObject.count();

        assertEquals(expected, actual);


    }



}
