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
}