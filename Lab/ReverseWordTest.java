package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 31
 * Aim: To reverse a given word and validate output using JUnit assertions.
 */
public class ReverseWordTest {

    public String reverseWord(String word) {
        if (word == null) return null;
        String rev = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            rev = rev + word.charAt(i);
        }
        return rev;
    }

    @Test
    public void testReverseWordNormal() {
        assertEquals("olleH", reverseWord("Hello"));
    }

    @Test
    public void testReverseSingleChar() {
        assertEquals("A", reverseWord("A"));
    }

    @Test
    public void testReverseWithSpaces() {
        assertEquals("dlroW olleH", reverseWord("Hello World"));
    }
}
