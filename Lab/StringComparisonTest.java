package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 24
 * Title: STRING EQUALITY IGNORING CASE USING JUNIT
 * Aim: To check whether two strings are equal ignoring case sensitivity and validate output using JUnit assertions.
 * 
 * NOTE & BUG FIX:
 * In the original lab manual code, `s1.equals(s2)` was used, which caused `compareStrings("Java", "java")`
 * to fail (it returned false instead of true).
 * As required by the Aim and Algorithm Step 2 ("Convert both strings to lowercase. Compare using equals()"),
 * this is fixed to use `s1.equalsIgnoreCase(s2)`.
 */
public class StringComparisonTest {

    public boolean compareStrings(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        // Fix: Case-insensitive comparison
        return s1.equalsIgnoreCase(s2);
    }

    @Test
    public void testStringEqual() {
        // Validates TC1: "Java", "java" -> True
        assertTrue(compareStrings("Java", "java"));
    }

    @Test
    public void testStringNotEqual() {
        // Validates TC2: "Java", "Python" -> False
        assertFalse(compareStrings("Java", "Python"));
    }

    @Test
    public void testNullString() {
        // Validates TC3: null, "Test" -> False
        assertFalse(compareStrings(null, "Test"));
    }
}
