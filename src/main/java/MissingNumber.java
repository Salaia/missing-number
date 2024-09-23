import java.util.Arrays;

/**
 * I decided to provide several solutions as I see some conflicts in problem description.
 * I probably should have asked some clarifying questions,
 * but solving several problems instead of one feels more challenging =)
 */
public class MissingNumber {

    /*
    Given array of sequent numbers 0,1,2,3...N with missing member.
    I'd like to solve it via natural sum.
     */
    public int findMissingNumberNaturalZero(int[] numbers) {
        int naturalSum = numbers.length * (numbers.length + 1) / 2;
        int actualSum = 0;

        for (int num : numbers) {
            actualSum += num;
        }

        return naturalSum - actualSum;
    }

    /*
    Example 2 gives us [7, 9,10, 11, 12] sequence, that doesn't start with 0.
    Again, this can be solved via natural sum. Just add the natural sum of ghost prev-numbers
     */
    public int findMissingNumberRandomSequenceViaNaturalSum(int[] numbers) {
        int min = numbers[0];
        int actualSum = 0;

        for (int num : numbers) {
            actualSum += num;
            if(num < min) {
                min = num;
            }
        }

        //add natural sum for non-existing previous part of array
        int prevNumber = min - 1;
        actualSum += prevNumber*(prevNumber+1)/2;

        int alteredLength = numbers.length + min;
        int naturalSum = alteredLength * (alteredLength + 1) / 2;

        return naturalSum - actualSum;
    }

    /*
    The last challenge is this:
    "Function finds a first missing number occurrence in the sequence"
    Wow, so there might be several missing numbers,
    and we need to find the first occurrence?..
    Well then, it's definitely work for sorting!
     */
    public int findFirstMissingNumber(int[] numbers) {
        Arrays.sort(numbers); // or we can sort manually
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i-1]+1) {
                return numbers[i]-1;
            }
        }
        return -1; // this is not meant to happen if there is at least one missing number, throw respective exception in prod
    }

}
