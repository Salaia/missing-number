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
    Again, this can be solved via natural sum. But is it good?
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
        int prevNumber = min - 1;
        while (prevNumber !=0) {
            actualSum += prevNumber;
            prevNumber--;
        }

        int alteredLength = numbers.length + min;
        int naturalSum = alteredLength * (alteredLength + 1) / 2;

        return naturalSum - actualSum;
    }

    /*
    What if we have [991,992,994,995] and natural sum will have too many steps?
    Sorting will work better if sequence length is much smaller, then starting number
     */
    public int sortAndSearchBigNumbers(int[] numbers) {
        Arrays.sort(numbers); // or we can sort manually
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i-1]+1) {
                return numbers[i]-1;
            }
        }
        return -1; // this is not meant to happen if testcase is correct, throw respective exception in prod
    }
}
