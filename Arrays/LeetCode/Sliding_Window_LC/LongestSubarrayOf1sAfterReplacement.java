package Arrays.LeetCode.Sliding_Window_LC;

/*
 LeetCode Problem: Longest Subarray of 1's After Deleting One Element

 Approach (Variable Sliding Window):
 - We are allowed to delete exactly one element.
 - This is equivalent to finding the longest subarray
   containing at most ONE zero.

 - Expand the window using `end`
 - Count zeros in the current window
 - If zeros > 1 → shrink window from the left
 - For every valid window:
       length = window size - 1
   because one element must be deleted

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class LongestSubarrayOf1sAfterReplacement {
    public static int longestSubarray(int[] nums) {

        int start = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int end = 0; end < nums.length; end++) {

            // Count zeros in current window
            if (nums[end] == 0) {
                zeroCount++;
            }

            // Window invalid if more than 1 zero
            while (zeroCount > 1) {

                if (nums[start] == 0) {
                    zeroCount--;
                }

                start++;
            }

            // We must delete one element → so subtract 1
            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int result = longestSubarray(nums);
        System.out.println(result);       
    }
}