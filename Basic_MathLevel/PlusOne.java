package Basic_MathLevel;

public class PlusOne {
    /*
     Problem: Plus One (LeetCode 66)

     Idea:
     - Given a non-empty array of digits representing a non-negative integer, add one to the integer.
     - Digits are stored such that the most significant digit is at the head of the array.
     - Handle carry propagation when digits are 9.

     Technique Used:
     Iterative Carry Handling

     - Traverse digits from right to left.
     - If the current digit is less than 9, increment it and return immediately.
     - If the digit is 9, set it to 0 and continue to propagate the carry.
     - If all digits are 9, create a new array with an extra leading 1.

     Time Complexity: O(n)
     Space Complexity: O(1) (except when creating a new array for all 9s case)
    */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;   // increment and return
                return digits;
            }
            digits[i] = 0;     // set to 0 and carry over
        }

        // Case: all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}