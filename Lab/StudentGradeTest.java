package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EXP NO: 25
 * Aim: To calculate grade of a student based on marks and validate output using JUnit assertions.
 */
public class StudentGradeTest {

    public String calculateGrade(int marks) {
        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "F";
    }

    @Test
    public void testGradeA() {
        assertEquals("A", calculateGrade(95));
    }

    @Test
    public void testGradeB() {
        assertEquals("B", calculateGrade(80));
    }

    @Test
    public void testGradeFail() {
        assertEquals("F", calculateGrade(40));
    }
}
