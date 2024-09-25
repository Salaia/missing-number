import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MissingNumberTest {

    MissingNumber mn = new MissingNumber();

    @Test
    public void findMissingNumberViaNaturalSum() {
        int[] input = {5, 0, 1, 3, 2};
        int expected = 4;
        int output = mn.findMissingNumberNaturalZero(input);
        assertEquals(expected, output);
    }

    @Test
    public void findMissingNumberViaFrequencyArray() {
        int[] input = {5, 0, 1, 3, 2};
        int expected = 4;
        int output = mn.findMissingNumberViaFrequencyArray(input);
        assertEquals(expected, output);
    }

    @Test
    public void findMissingNumberViaIndexSum() {
        int[] input = {5, 0, 1, 3, 2};
        int expected = 4;
        int output = mn.findMissingNumberViaIndexSum(input);
        assertEquals(expected, output);
    }

    @Test
    public void failFindMissingNumberViaNaturalSum() {
        int[] input = {7, 9, 10, 11, 12};
        int expected = 8;
        int output = mn.findMissingNumberNaturalZero(input);
        assertNotEquals(expected, output);
    }

    @Test
    public void findMissingNumberInRandomSequence() {
        int[] input = {7, 9, 10, 11, 12};
        int expected = 8;
        int output = mn.findMissingNumberRandomSequenceViaNaturalSum(input);
        assertEquals(expected, output);
    }

    @Test
    public void findMissingNumberInRandomSequenceBySort() {
        int[] input = {997, 995, 994, 992, 991};
        int expected = 993;
        int output = mn.findMinimumMissingNumberAmongUnique(input);
        assertEquals(expected, output);
    }

    @Test
    public void findMissingNumberInNonUniqueRandomSequenceBySort() {
        int[] input = {997, 995, 994, 992, 991, 995, 992};
        int expected = 993;
        int output = mn.findMinimumMissingNumberAmongNonUnique(input);
        assertEquals(expected, output);
    }

    /* Oops, overflow!
        All methods using sums might get wrong answers because of capacity overflow.
        Sorting methods won't have this problem.
     */

    @Test
    public void sumOverflow() {
        int output = mn.findMissingNumberRandomSequenceViaNaturalSum(new int[]{Integer.MAX_VALUE - 2, Integer.MAX_VALUE});
        int expected = Integer.MAX_VALUE - 1;
        // output is -2, the program won't even throw an exception.
        assertNotEquals(expected, output);
    }

    @Test
    public void noSumNoSumOverflowAmongUnique() {
        int output = mn.findMinimumMissingNumberAmongUnique(new int[]{Integer.MAX_VALUE - 2, Integer.MAX_VALUE});
        int expected = Integer.MAX_VALUE - 1;
        assertEquals(expected, output);
    }

    @Test
    public void noSumNoSumOverflowAmongNonUnique() {
        int output = mn.findMinimumMissingNumberAmongNonUnique(new int[]{Integer.MAX_VALUE - 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
        int expected = Integer.MAX_VALUE - 1;
        assertEquals(expected, output);
    }

    /*
    What if we have negative numbers in sequence?
     */

    @Test
    public void throwExceptionViaFrequencyArray() {
        int[] input = {-7, -9, -10, -11, -12};
        //int missingNumber = -8;
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            mn.findMissingNumberViaFrequencyArray(input);
        });
        String expected = "Index -7 out of bounds for length 6";
        String actual = exception.getMessage();

        assertTrue(expected.contains(actual));
    }

    @Test
    public void failNegativeViaIndexSum() {
        int[] input = {-7, -9, -10, -11, -12};
        int expected = -8;
        int output = mn.findMissingNumberViaIndexSum(input);
        assertNotEquals(expected, output);
    }

    @Test
    public void findNegativeViaRandomSequenceNaturalSum() {
        int[] input = {-7, -9, -10, -11, -12};
        int expected = -8;
        int output = mn.findMissingNumberRandomSequenceViaNaturalSum(input);
        assertEquals(expected, output);
    }

    @Test
    public void findNegativeMissingNumberViaSortAmongUnique() {
        int[] input = {-7, -9, -10, -11, -12};
        int expected = -8;
        int output = mn.findMinimumMissingNumberAmongUnique(input);
        assertEquals(expected, output);
    }

    /*
     *  Testing borders
     */

    @Test
    public void findZeroViaNaturalSum(){
        int[] input = {1,2,3};
        int expected = 0;
        int output = mn.findMissingNumberNaturalZero(input);
        assertEquals(expected, output);
    }

    @Test
    public void findZeroViaFrequencyArray(){
        int[] input = {1,2,3};
        int expected = 0;
        int output = mn.findMissingNumberViaFrequencyArray(input);
        assertEquals(expected, output);
    }

    @Test
    public void findZeroViaIndexSum(){
        int[] input = {1,2,3};
        int expected = 0;
        int output = mn.findMissingNumberViaIndexSum(input);
        assertEquals(expected, output);
    }

    @Test
    public void failZeroViaSorting(){
        int[] input = {1,2,3};
        int expected = 0;
        int output = mn.findMinimumMissingNumberAmongUnique(input);
        assertNotEquals(expected, output);
    }

    @Test
    public void findNViaIndexSum(){
        int[] input = {0,1,2};
        int expected = 3;
        int output = mn.findMissingNumberViaIndexSum(input);
        assertEquals(expected, output);
    }

    @Test
    public void findNViaFrequencyArray(){
        int[] input = {0,1,2};
        int expected = 3;
        int output = mn.findMissingNumberViaFrequencyArray(input);
        assertEquals(expected, output);
    }

    @Test
    public void findNViaNaturalSum(){
        int[] input = {0,1,2};
        int expected = 3;
        int output = mn.findMissingNumberNaturalZero(input);
        assertEquals(expected, output);
    }

    @Test
    public void failFindNViaSorting(){
        int[] input = {0,1,2};
        int expected = 3;
        int output = mn.findMinimumMissingNumberAmongUnique(input);
        assertNotEquals(expected, output);
    }

    @Test
    public void findMinNextToBorderViaSort(){
        int[] input = {1,3,4};
        int expected = 2;
        int output = mn.findMinimumMissingNumberAmongUnique(input);
        assertEquals(expected, output);
    }

    @Test
    public void findMaxNextToBorderViaSort(){
        int[] input = {1,2,4};
        int expected = 3;
        int output = mn.findMinimumMissingNumberAmongUnique(input);
        assertEquals(expected, output);
    }

}