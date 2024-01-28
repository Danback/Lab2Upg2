import org.example.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}