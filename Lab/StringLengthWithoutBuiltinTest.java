package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 30
 * Aim: To find the length of a string without using built-in length() function and validate output using JUnit assertions.
 */
public class StringLengthWithoutBuiltinTest {

    public int findLength(String s) {
        if (s == null) return 0;
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    @Test
    public void testStringLengthNormal() {
        assertEquals(5, findLength("Hello"));
    }

    @Test
    public void testStringLengthEmpty() {
        assertEquals(0, findLength(""));
    }

    @Test
    public void testStringLengthWithSpaces() {
        assertEquals(11, findLength("Hello World"));
    }
}
