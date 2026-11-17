package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 18
 * Aim: To check whether a number is even or odd and validate output using JUnit assertions.
 */
public class EvenOddTest {

    public String checkEvenOdd(int n) {
        if (n % 2 == 0)
            return "Even";
        else
            return "Odd";
    }

    @Test
    public void testEvenNumber() {
        assertEquals("Even", checkEvenOdd(10));
    }

    @Test
    public void testOddNumber() {
        assertEquals("Odd", checkEvenOdd(15));
    }

    @Test
    public void testZero() {
        assertEquals("Even", checkEvenOdd(0));
    }
}
