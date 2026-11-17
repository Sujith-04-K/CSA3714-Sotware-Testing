package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 28
 * Aim: To check whether a given number is an Armstrong number and validate output using JUnit assertions.
 */
public class ArmstrongNumberTest {

    public boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        int digits = 0;
        int temp = n;
        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }
        temp = n;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp = temp / 10;
        }
        return sum == original;
    }

    @Test
    public void testArmstrongTrue() {
        assertTrue(isArmstrong(153));
    }

    @Test
    public void testArmstrongFalse() {
        assertFalse(isArmstrong(123));
    }

    @Test
    public void testArmstrongSingleDigit() {
        assertTrue(isArmstrong(7));
    }
}
