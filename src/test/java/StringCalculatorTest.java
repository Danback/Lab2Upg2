import org.example.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {
    @Test
    public void shouldReturnZeroOnEmptyString() {
        assertEquals(0, StringCalculator.Add(""));
    }

    @Test
    public void shouldReturnSumOnTwoNumbers() {
        assertEquals(3, StringCalculator.Add("1,2"));
    }

    @Test
    public void shouldReturnSumOnMultipleNumbers() {
        assertEquals(6, StringCalculator.Add("1,2,3"));
    }

    @Test
    public void shouldHandleNewLinesBetweenNumbers() {
        assertEquals(6, StringCalculator.Add("1\n2,3"));
    }

    @Test
    public void shouldHandleNewLinesAsOnlyDelimiter() {
        assertEquals(10, StringCalculator.Add("1\n2\n3\n4"));
    }

    @Test
    public void shouldHandleCustomDelimiter() {
        assertEquals(3, StringCalculator.Add("//;\n1;2"));
    }

    @Test
    public void shouldHandleCustomDelimiterWithMultipleNumbers() {
        assertEquals(10, StringCalculator.Add("//-\n1-2-3-4"));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.Add("1,-2,3");
        });
        assertEquals("Negatives not allowed: -2", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionShowingAllNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.Add("1,-2,3,-4");
        });
        assertEquals("Negatives not allowed: -2, -4", exception.getMessage());
    }

    @Test
    public void numbersGreaterThan1000ShouldBeIgnored() {
        assertEquals(2, StringCalculator.Add("2,1001"));
    }

    @Test
    public void numbersEqualToOrLessThan1000ShouldBeIncluded() {
        assertEquals(1002, StringCalculator.Add("2,1000"));
    }

    @Test
    public void shouldHandleDelimitersOfAnyLength() {
        assertEquals(6, StringCalculator.Add("//[***]\n1***2***3"));
    }

    @Test
    public void shouldHandleDifferentDelimitersOfVariousLengths() {
        assertEquals(10, StringCalculator.Add("//[**][%%]\n1**2%%3**4"));
    }
}