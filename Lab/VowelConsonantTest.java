package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VowelConsonantTest {
    @Test void testNormalString() {
        int[] result = VowelConsonant.count("Hello");
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
    }
    @Test void testOnlyVowels() {
        int[] result = VowelConsonant.count("aeiou");
        assertEquals(5, result[0]);
        assertEquals(0, result[1]);
    }
    @Test void testEmptyString() {
        int[] result = VowelConsonant.count("");
        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
    }
    @Test void testSpacesAndDigits() {
        int[] result = VowelConsonant.count("A1 B!");
        assertEquals(1, result[0]);
        assertEquals(1, result[1]);
    }
}
