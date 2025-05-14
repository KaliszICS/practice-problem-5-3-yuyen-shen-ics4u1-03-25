import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PracticeProblemTest {

    @Test
    @DisplayName("Check proper implementation of abstract methods")
    void testAbstractMethodImplementation() {
        try {
            Class<?> animalClass = Class.forName("Animal");
            Class<?> catClass = Class.forName("Cat");
            Class<?> birdClass = Class.forName("Bird");
            Class<?> bearClass = Class.forName("Bear");
            
            // Check that animalSound is abstract in Animal
            Method animalSoundInAnimal = animalClass.getDeclaredMethod("animalSound");
            assertTrue(Modifier.isAbstract(animalSoundInAnimal.getModifiers()), 
                    "animalSound should be abstract in Animal class");
            
            // Check that animalSound is implemented (not abstract) in each subclass
            Method animalSoundInCat = catClass.getDeclaredMethod("animalSound");
            assertFalse(Modifier.isAbstract(animalSoundInCat.getModifiers()), 
                    "animalSound should be implemented in Cat class");
            
            Method animalSoundInBird = birdClass.getDeclaredMethod("animalSound");
            assertFalse(Modifier.isAbstract(animalSoundInBird.getModifiers()), 
                    "animalSound should be implemented in Bird class");
            
            Method animalSoundInBear = bearClass.getDeclaredMethod("animalSound");
            assertFalse(Modifier.isAbstract(animalSoundInBear.getModifiers()), 
                    "animalSound should be implemented in Bear class");
            
        } catch (ClassNotFoundException e) {
            fail("Required class does not exist: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            fail("Required method does not exist: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Check Animal inheritance structure")
    void testAnimalInheritanceStructure() {
        try {
            Class<?> animalClass = Class.forName("Animal");
            Class<?> catClass = Class.forName("Cat");
            Class<?> birdClass = Class.forName("Bird");
            Class<?> bearClass = Class.forName("Bear");
            
            // Check that Animal is the parent of all three classes
            assertEquals(animalClass, catClass.getSuperclass(), "Cat should directly extend Animal");
            assertEquals(animalClass, birdClass.getSuperclass(), "Bird should directly extend Animal");
            assertEquals(animalClass, bearClass.getSuperclass(), "Bear should directly extend Animal");
            
            // Check that Animal is abstract but subclasses are not
            assertTrue(Modifier.isAbstract(animalClass.getModifiers()), "Animal class should be abstract");
            assertFalse(Modifier.isAbstract(catClass.getModifiers()), "Cat class should not be abstract");
            assertFalse(Modifier.isAbstract(birdClass.getModifiers()), "Bird class should not be abstract");
            assertFalse(Modifier.isAbstract(bearClass.getModifiers()), "Bear class should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Required class does not exist: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Check if Animal class exists and is abstract")
    void testAnimalClassExists() {
        try {
            Class<?> animalClass = Class.forName("Animal");
            assertTrue(Modifier.isAbstract(animalClass.getModifiers()), "Animal class should be abstract");
        } catch (ClassNotFoundException e) {
            fail("Animal class does not exist");
        }
    }

    @Test
    @DisplayName("Check Animal constructor")
    void testAnimalConstructor() {
        try {
            Class<?> animalClass = Class.forName("Animal");
            Constructor<?> constructor = animalClass.getDeclaredConstructor(String.class, int.class, String.class, int.class);
            assertNotNull(constructor, "Animal constructor with (String, int, String, int) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Animal class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Animal constructor with (String, int, String, int) parameters does not exist");
        }
    }

    @Test
    @DisplayName("Check Animal methods")
    void testAnimalMethods() {
        try {
            Class<?> animalClass = Class.forName("Animal");
            
            // Check getName method
            Method getNameMethod = animalClass.getDeclaredMethod("getName");
            assertEquals(String.class, getNameMethod.getReturnType(), "getName method should return String");
            
            // Check getAge method
            Method getAgeMethod = animalClass.getDeclaredMethod("getAge");
            assertEquals(int.class, getAgeMethod.getReturnType(), "getAge method should return int");
            
            // Check getType method
            Method getTypeMethod = animalClass.getDeclaredMethod("getType");
            assertEquals(String.class, getTypeMethod.getReturnType(), "getType method should return String");
            
            // Check getPosition method
            Method getPositionMethod = animalClass.getDeclaredMethod("getPosition");
            assertEquals(int.class, getPositionMethod.getReturnType(), "getPosition method should return int");
            
            // Check move method
            Method moveMethod = animalClass.getDeclaredMethod("move");
            assertEquals(void.class, moveMethod.getReturnType(), "move method should return void");
            
            // Check sleep method
            Method sleepMethod = animalClass.getDeclaredMethod("sleep");
            assertEquals(String.class, sleepMethod.getReturnType(), "sleep method should return String");
            
            // Check animalSound method
            Method animalSoundMethod = animalClass.getDeclaredMethod("animalSound");
            assertEquals(String.class, animalSoundMethod.getReturnType(), "animalSound method should return String");
            assertTrue(Modifier.isAbstract(animalSoundMethod.getModifiers()), "animalSound method should be abstract");
            
        } catch (ClassNotFoundException e) {
            fail("Animal class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Required method does not exist: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Check if Cat class exists and properly extends Animal")
    void testCatClassExists() {
        try {
            Class<?> catClass = Class.forName("Cat");
            Class<?> animalClass = Class.forName("Animal");
            
            // Check direct inheritance
            assertEquals(animalClass, catClass.getSuperclass(), "Cat should directly extend Animal");
            
            // Check that it's not abstract
            assertFalse(Modifier.isAbstract(catClass.getModifiers()), "Cat class should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Required class does not exist: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Check Cat constructor")
    void testCatConstructor() {
        try {
            Class<?> catClass = Class.forName("Cat");
            Constructor<?> constructor = catClass.getDeclaredConstructor(String.class, int.class, String.class, int.class);
            assertNotNull(constructor, "Cat constructor with (String, int, String, int) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Cat class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Cat constructor with (String, int, String, int) parameters does not exist");
        }
    }

    @Test
    @DisplayName("Check Cat animalSound implementation")
    void testCatAnimalSound() {
        try {
            Class<?> catClass = Class.forName("Cat");
            Method animalSoundMethod = catClass.getDeclaredMethod("animalSound");
            assertEquals(String.class, animalSoundMethod.getReturnType(), "animalSound method should return String");
            assertFalse(Modifier.isAbstract(animalSoundMethod.getModifiers()), "Cat's animalSound method should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Cat class does not exist");
        } catch (NoSuchMethodException e) {
            fail("animalSound method does not exist in Cat class");
        }
    }

    @Test
    @DisplayName("Check Cat move implementation")
    void testCatMove() {
        try {
            Class<?> catClass = Class.forName("Cat");
            Method moveMethod = catClass.getDeclaredMethod("move");
            assertEquals(void.class, moveMethod.getReturnType(), "move method should return void");
            assertFalse(Modifier.isAbstract(moveMethod.getModifiers()), "Cat's move method should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Cat class does not exist");
        } catch (NoSuchMethodException e) {
            fail("move method does not exist in Cat class");
        }
    }

    @Test
    @DisplayName("Check if Bird class exists and properly extends Animal")
    void testBirdClassExists() {
        try {
            Class<?> birdClass = Class.forName("Bird");
            Class<?> animalClass = Class.forName("Animal");
            
            // Check direct inheritance
            assertEquals(animalClass, birdClass.getSuperclass(), "Bird should directly extend Animal");
            
            // Check that it's not abstract
            assertFalse(Modifier.isAbstract(birdClass.getModifiers()), "Bird class should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Required class does not exist: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Check Bird constructor")
    void testBirdConstructor() {
        try {
            Class<?> birdClass = Class.forName("Bird");
            Constructor<?> constructor = birdClass.getDeclaredConstructor(String.class, int.class, String.class, int.class);
            assertNotNull(constructor, "Bird constructor with (String, int, String, int) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Bird class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Bird constructor with (String, int, String, int) parameters does not exist");
        }
    }

    @Test
    @DisplayName("Check Bird animalSound implementation")
    void testBirdAnimalSound() {
        try {
            Class<?> birdClass = Class.forName("Bird");
            Method animalSoundMethod = birdClass.getDeclaredMethod("animalSound");
            assertEquals(String.class, animalSoundMethod.getReturnType(), "animalSound method should return String");
            assertFalse(Modifier.isAbstract(animalSoundMethod.getModifiers()), "Bird's animalSound method should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Bird class does not exist");
        } catch (NoSuchMethodException e) {
            fail("animalSound method does not exist in Bird class");
        }
    }

    @Test
    @DisplayName("Check Bird move implementation")
    void testBirdMove() {
        try {
            Class<?> birdClass = Class.forName("Bird");
            Method moveMethod = birdClass.getDeclaredMethod("move");
            assertEquals(void.class, moveMethod.getReturnType(), "move method should return void");
            assertFalse(Modifier.isAbstract(moveMethod.getModifiers()), "Bird's move method should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Bird class does not exist");
        } catch (NoSuchMethodException e) {
            fail("move method does not exist in Bird class");
        }
    }

    @Test
    @DisplayName("Check if Bear class exists and properly extends Animal")
    void testBearClassExists() {
        try {
            Class<?> bearClass = Class.forName("Bear");
            Class<?> animalClass = Class.forName("Animal");
            
            // Check direct inheritance
            assertEquals(animalClass, bearClass.getSuperclass(), "Bear should directly extend Animal");
            
            // Check that it's not abstract
            assertFalse(Modifier.isAbstract(bearClass.getModifiers()), "Bear class should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Required class does not exist: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Check Bear constructor")
    void testBearConstructor() {
        try {
            Class<?> bearClass = Class.forName("Bear");
            Constructor<?> constructor = bearClass.getDeclaredConstructor(String.class, int.class, String.class, int.class);
            assertNotNull(constructor, "Bear constructor with (String, int, String, int) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Bear class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Bear constructor with (String, int, String, int) parameters does not exist");
        }
    }

    @Test
    @DisplayName("Check Bear animalSound implementation")
    void testBearAnimalSound() {
        try {
            Class<?> bearClass = Class.forName("Bear");
            Method animalSoundMethod = bearClass.getDeclaredMethod("animalSound");
            assertEquals(String.class, animalSoundMethod.getReturnType(), "animalSound method should return String");
            assertFalse(Modifier.isAbstract(animalSoundMethod.getModifiers()), "Bear's animalSound method should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Bear class does not exist");
        } catch (NoSuchMethodException e) {
            fail("animalSound method does not exist in Bear class");
        }
    }

    @Test
    @DisplayName("Check Bear move implementation")
    void testBearMove() {
        try {
            Class<?> bearClass = Class.forName("Bear");
            Method moveMethod = bearClass.getDeclaredMethod("move");
            assertEquals(void.class, moveMethod.getReturnType(), "move method should return void");
            assertFalse(Modifier.isAbstract(moveMethod.getModifiers()), "Bear's move method should not be abstract");
        } catch (ClassNotFoundException e) {
            fail("Bear class does not exist");
        } catch (NoSuchMethodException e) {
            fail("move method does not exist in Bear class");
        }
    }
}

