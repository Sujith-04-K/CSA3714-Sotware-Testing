package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCompareTest {
    @Test void testSameString() {
        assertTrue(StringCompare.areEqual("Java", "JAVA"));
    }
    @Test void testDifferentStrings() {
        assertFalse(StringCompare.areEqual("Hello", "World"));
    }
    @Test void testEmptyStrings() {
        assertTrue(StringCompare.areEqual("", ""));
    }
    @Test void testDifferentLengths() {
        assertFalse(StringCompare.areEqual("Java", "Jav"));
    }
}
