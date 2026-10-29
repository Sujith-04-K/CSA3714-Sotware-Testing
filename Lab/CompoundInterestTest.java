package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompoundInterestTest {
    @Test void testCompoundAmount() {
        assertEquals(1210.0, CompoundInterest.calculateAmount(1000, 10, 2), 0.01);
    }
    @Test void testCompoundInterest() {
        assertEquals(210.0, CompoundInterest.calculateInterest(1000, 10, 2), 0.01);
    }
    @Test void testZeroTime() {
        assertEquals(1000.0, CompoundInterest.calculateAmount(1000, 10, 0), 0.01);
    }
}
