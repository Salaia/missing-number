import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MissingNumberTest {

    MissingNumber mn = new MissingNumber();

    @Test
    public void findMissingNumberViaNaturalSum() {
        int[] input = {5,0,1,3,2};
        int expected = 4;
        int output = mn.findMissingNumberNaturalZero(input);
        assertEquals(expected, output);
    }

    @Test
    public void failFindMissingNumberViaNaturalSum() {
        int[] input = {7, 9,10, 11, 12};
        int expected = 8;
        int output = mn.findMissingNumberNaturalZero(input);
        assertNotEquals(expected, output);
    }

    @Test
    public void findMissingNumberInRandomSequence() {
        int[] input = {7, 9,10, 11, 12};
        int expected = 8;
        int output = mn.findMissingNumberRandomSequenceViaNaturalSum(input);
        assertEquals(expected, output);
    }

    @Test
    public void findMissingNumberInRandomSequenceBySort() {
        int[] input = {997,995,994,992,991};
        int expected = 993;
        int output = mn.findFirstMissingNumber(input);
        assertEquals(expected, output);
    }
}