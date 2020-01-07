import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class UtilsTest {

    private Utils subject;

    @Before
    public void setUp() {
        subject = new Utils();
    }

    @Test
    public void isPalindrome() {
        assertTrue(subject.isPalindrome("kayak"));
        assertTrue(subject.isPalindrome("parterretrap"));
        assertTrue(subject.isPalindrome("radar"));
        assertFalse(subject.isPalindrome("notapalindrome"));
    }

    @Test
    public void isArmstrongNumber() {
        assertTrue(subject.isArmstrongNumber(153));
        assertTrue(subject.isArmstrongNumber(371));
        assertFalse(subject.isArmstrongNumber(99));
    }

    @Test
    public void eachWordWithCapitalLetter() {
        assertEquals("Its Ok To Be Given A Second Chance", subject.eachWordWithCapitalLetter("its ok to be given a second chance"));
        assertEquals("Mary Had A Little  Lamb Its Fleece Was White As Snow", subject.eachWordWithCapitalLetter("mary had a little  lamb its fleece was white as snow"));
    }

    @Test
    public void closestNumberToZeroIfPositive() {
        assertEquals(1, subject.closestNumberToZeroIfSamePositive(new int[]{1, -1, 0, 7, 14, 12, -3, -6, 1}));
        assertEquals(1, subject.closestNumberToZeroIfSamePositive(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void getWordsStartingWith() {
        String[] strings = {"java", "apa", "beda", "josu", "jaja"};
        String[] expected = {"java", "jaja"};
        assertEquals(Arrays.asList(expected), subject.getWordsStartingWith(strings, "ja"));
    }

    @Test
    public void elementBeforeAnother() {
        String[] initialFruits = {"banana", "berry", "coconut", "strawberry", "mango", "apple"};
        String[] sortedFruits = {"apple", "banana", "berry", "coconut", "mango", "strawberry"};

        String apple = initialFruits[5];
        String banana = initialFruits[0];

        assertFalse(subject.elementBeforeAnother(initialFruits, apple, banana));
        assertTrue(subject.elementBeforeAnother(sortedFruits, apple, banana));
    }

    @Test
    public void sortAnimalOnAge() {
        Animal snake = new Animal.Builder().name("Snake").age(2).build();
        Animal lion = new Animal.Builder().name("Lion").age(7).build();
        Animal rhino = new Animal.Builder().name("Rhino").age(20).build();
        Animal mouse = new Animal.Builder().name("Mouse").age(1).build();

        List<Animal> animals = Arrays.asList(snake, lion, rhino, mouse);

        Collections.sort(animals);

        assertEquals(Arrays.asList(mouse, snake,lion,rhino), subject.sortAnimals(animals));
    }
}