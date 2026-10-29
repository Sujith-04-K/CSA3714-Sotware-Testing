package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    @Test void testAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
    }
    @Test void testNotAnagram() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }
    @Test void testDifferentLengths() {
        assertFalse(Anagram.isAnagram("cat", "cats"));
    }
    @Test void testIgnoreCase() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
    }
}
