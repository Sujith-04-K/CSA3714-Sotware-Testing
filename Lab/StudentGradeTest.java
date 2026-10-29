package lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentGradeTest {
    @Test void testGradeA() {
        assertEquals("A", StudentGrade.calculateGrade(95));
    }
    @Test void testGradeB() {
        assertEquals("B", StudentGrade.calculateGrade(85));
    }
    @Test void testGradeC() {
        assertEquals("C", StudentGrade.calculateGrade(75));
    }
    @Test void testGradeD() {
        assertEquals("D", StudentGrade.calculateGrade(65));
    }
    @Test void testGradeF() {
        assertEquals("F", StudentGrade.calculateGrade(40));
    }
    @Test void testBoundaryMarks() {
        assertEquals("A", StudentGrade.calculateGrade(90));
        assertEquals("B", StudentGrade.calculateGrade(80));
        assertEquals("F", StudentGrade.calculateGrade(59));
    }
    @Test void testInvalidMarks() {
        assertEquals("Invalid", StudentGrade.calculateGrade(-1));
        assertEquals("Invalid", StudentGrade.calculateGrade(101));
    }
}
