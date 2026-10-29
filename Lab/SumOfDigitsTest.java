package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsTest {
    @Test void testNormalNumber() {
        assertEquals(15, SumOfDigits.sum(12345));
    }
    @Test void testSingleDigit() {
        assertEquals(7, SumOfDigits.sum(7));
    }
    @Test void testZero() {
        assertEquals(0, SumOfDigits.sum(0));
    }
    @Test void testNegativeNumber() {
        assertEquals(6, SumOfDigits.sum(-123));
    }
}
