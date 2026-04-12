package Basic_MathLevel;

/*
 Problem: Count Digit Occurrences

 Idea:
 - Given an array of integers nums[] and a digit (0–9).
 - We need to count how many times the digit appears in all numbers of the array.
 - Example: nums = [12, 20, 303], digit = 0 → output = 3 (digits at positions in 20 and 303).

 Technique Used:
 Simple Iteration + Modulo Operation

 Time Complexity: O(total_digits) → proportional to number of digits across all numbers.
 Space Complexity: O(1)
*/

public class CountDigitOccurrences {
    public int countDigitOccurrences(int[] nums, int digit) {
        int c = 0; // counter for occurrences

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            // Special case: number is 0 and digit is 0
            if (n == 0 && digit == 0) {
                c++;
                continue;
            }

            // Extract digits one by one
            while (n > 0) {
                int rem = n % 10; // last digit
                if (rem == digit) c++; // match found
                n = n / 10; // remove last digit
            }
        }
        return c;
    }
}