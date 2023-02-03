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

    @Autowired
    IngredientRepository testObject;

    Ingredient createdIngredient;

    @BeforeEach
    public void setup(){
         Ingredient ingredient = new Ingredient("test");
         createdIngredient = testObject.save(ingredient);
         assertNotNull(createdIngredient);
    }


    @Test
    public void test_findById(){
      Optional<Ingredient> optionalIngredient = testObject.findById(createdIngredient.getId());
      assertTrue(optionalIngredient.isPresent());
      Ingredient actual = optionalIngredient.get();
      Ingredient expected = createdIngredient;
      assertEquals(expected,actual);

    }

    @Test
    public void test_update(){

        testObject.updateIngredientName("apple",createdIngredient.getId());

        Optional<Ingredient> optionalIngredient = testObject.findById(createdIngredient.getId());
        assertTrue(optionalIngredient.isPresent());
        Ingredient ingredient = optionalIngredient.get();


        assertNotEquals(ingredient, createdIngredient.getId());


    }

}
