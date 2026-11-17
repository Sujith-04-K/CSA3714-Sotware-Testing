package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 34
 * Title: SIMPLE INTEREST CALCULATION (SENIOR CITIZEN) USING JUNIT
 * Aim: To calculate simple interest based on customer type and validate output using JUnit assertions.
 */
public class SimpleInterestTest {

    public double calculateSimpleInterest(double principal, int time, boolean isSeniorCitizen) {
        double rate;
        if (isSeniorCitizen)
            rate = 12.0;
        else
            rate = 10.0;
        return (principal * rate * time) / 100.0;
    }

    @Test
    public void testSeniorCitizenInterest() {
        assertEquals(1200.0, calculateSimpleInterest(10000, 1, true), 0.01);
    }

    @Test
    public void testNormalCustomerInterest() {
        assertEquals(1000.0, calculateSimpleInterest(10000, 1, false), 0.01);
    }

    @Test
    public void testSeniorCitizenTwoYears() {
        assertEquals(2400.0, calculateSimpleInterest(10000, 2, true), 0.01);
    }
}
