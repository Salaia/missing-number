import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MissingNumberTest {

    MissingNumber mn = new MissingNumber();

    @Test
    /*
        Given array of sequent numbers 0,1,2,3...N with missing member.
        Here it works fine, as it really is an 0,1,2,3...N array
     */
    public void findMissingNumberViaNaturalSum() {
        int[] input = {5,0,1,3,2};
        int expected = 4;
        int output = mn.findMissingNumberNaturalZero(input);
        assertEquals(expected, output);
    }

    @Test
    // But we fail finding missing number via natural sum with randomly starting sequence
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
        int[] input = {991,992,994,995};
        int expected = 993;
        int output = mn.sortAndSearchBigNumbers(input);
        assertEquals(expected, output);
    }
}