package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 23
 * Aim: To find the sum of digits of a given number and validate output using JUnit assertions.
 */
public class SumOfDigitsTest {

    public int sumOfDigits(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n != 0) {
            int digit = n % 10;
            sum = sum + digit;
            n = n / 10;
        }
        return sum;
    }

    @Test
    public void testSumDigitsNormal() {
        assertEquals(6, sumOfDigits(123));
    }

    @Test
    public void testSumDigitsZero() {
        assertEquals(0, sumOfDigits(0));
    }

    @Test
    public void testSumDigitsLarge() {
        assertEquals(15, sumOfDigits(555));
    }
}
