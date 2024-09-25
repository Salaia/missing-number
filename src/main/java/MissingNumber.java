import java.util.Arrays;

/**
 * I decided to provide several solutions as I see some conflicts in problem description.
 * I probably should have asked some clarifying questions,
 * but solving several problems instead of one feels more challenging =)
 *
 * Since problem description doesn't give any curtain constraints
 * I won't test heap size / VM memory overflow and just hope incoming sequence is meant to have reasonable size =)
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
    Or we can use a frequency array.
    Again, we can do so in case sequence is 0,1,2,3...N with missing member
     */
    public int findMissingNumberViaFrequencyArray(int[] nums) {
        int[] frequency = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            frequency[nums[i]]++;
        }
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 0) return i;
        }
        return -1;
    }

    /*
    Another approach is to sum up indexes (0,1,2,3...N only)
     */
    public int findMissingNumberViaIndexSum(int[] nums) {
        int IndexSum = 0;
        int valuesSum = 0;
        for (int i = 0; i <= nums.length; i++) {
            IndexSum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            valuesSum += nums[i];
        }
        return IndexSum - valuesSum;
    }


    /*
    Example 2 gives us [7, 9,10, 11, 12] sequence, that doesn't start with 0.
    Again, this can be solved via natural sum. Just add the natural sum of ghost prev-numbers.
    This approach can also manage negative numbers.
     */
    public int findMissingNumberRandomSequenceViaNaturalSum(int[] numbers) {
        int min = numbers[0];
        int actualSum = 0;

        for (int num : numbers) {
            actualSum += num;
            // can be replaced with    min = Math.min(min,num);
            if (num < min) {
                min = num;
            }
        }

        //add natural sum for non-existing previous part of array
        int prevNumber = min - 1;
        actualSum += prevNumber * (prevNumber + 1) / 2;

        int alteredLength = numbers.length + min;
        int naturalSum = alteredLength * (alteredLength + 1) / 2;

        return naturalSum - actualSum;
    }

    /*
    The last challenge is this:
    "Function finds a first missing number occurrence in the sequence"
    Wow, so there might be several missing numbers,
    and we need to find the first occurrence?..
    Unfortunately, it's impossible as the incoming sequence isn't sorted.
    Yet we can sort it and find the minimum (or the maximum, if you like) missing number.
     */
    public int findMinimumMissingNumberAmongUnique(int[] numbers) {
        Arrays.sort(numbers); // or we can sort manually
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1] + 1) {
                return numbers[i] - 1;
            }
        }
        return -1; // this is not meant to happen if there is at least one missing number, throw respective exception in prod
    }

    /*
        Did I say it was the last challenge?
        Nope, we're not told we have a sequence of unique numbers.
        So, what if they're not unique?
     */
    public int findMinimumMissingNumberAmongNonUnique(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1] && numbers[i - 1] + 1 != numbers[i]) {
                return numbers[i - 1] + 1;
            }
        }
        return -1; // this is not meant to happen if there is at least one missing number, throw respective exception in prod
    }
}
