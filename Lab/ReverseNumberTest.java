package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseNumberTest {
    @Test void testReverse() {
        assertEquals(54321, ReverseNumber.reverse(12345));
    }
    @Test void testZero() {
        assertEquals(0, ReverseNumber.reverse(0));
    }
    @Test void testTrailingZeros() {
        assertEquals(321, ReverseNumber.reverse(12300));
    }
    @Test void testNegativeNumber() {
        assertEquals(-321, ReverseNumber.reverse(-123));
    }
}
