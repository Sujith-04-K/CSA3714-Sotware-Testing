package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaximumTest {
    @Test void testFirstIsMaximum() {
        assertEquals(10, Maximum.findMax(10, 5, 3));
    }
    @Test void testSecondIsMaximum() {
        assertEquals(20, Maximum.findMax(5, 20, 3));
    }
    @Test void testThirdIsMaximum() {
        assertEquals(30, Maximum.findMax(5, 10, 30));
    }
    @Test void testEqualNumbers() {
        assertEquals(5, Maximum.findMax(5, 5, 5));
    }
}
