package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LargestArrayTest {
    @Test void testLargestElement() {
        assertEquals(50, LargestArray.findLargest(new int[]{10, 20, 50, 30}));
    }
    @Test void testNegativeElements() {
        assertEquals(-1, LargestArray.findLargest(new int[]{-10, -5, -1, -8}));
    }
    @Test void testSingleElement() {
        assertEquals(7, LargestArray.findLargest(new int[]{7}));
    }
    @Test void testEmptyArray() {
        assertThrows(IllegalArgumentException.class,
            () -> LargestArray.findLargest(new int[]{}));
    }
    @Test void testNullArray() {
        assertThrows(IllegalArgumentException.class,
            () -> LargestArray.findLargest(null));
    }
}
