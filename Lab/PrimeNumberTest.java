package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {
    @Test void testPrime() {
        assertTrue(PrimeNumber.isPrime(7));
    }
    @Test void testComposite() {
        assertFalse(PrimeNumber.isPrime(12));
    }
    @Test void testOne() {
        assertFalse(PrimeNumber.isPrime(1));
    }
    @Test void testZero() {
        assertFalse(PrimeNumber.isPrime(0));
    }
    @Test void testTwo() {
        assertTrue(PrimeNumber.isPrime(2));
    }
}
