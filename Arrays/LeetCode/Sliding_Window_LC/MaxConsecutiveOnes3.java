package Arrays.LeetCode.Sliding_Window_LC;

/*
 LeetCode Problem: Max Consecutive Ones III

 Approach (Variable Sliding Window):
 - Expand the window by moving `end`
 - Count number of zeros in the current window
 - If zeros > k → shrink window from the left until zeros ≤ k
 - Track maximum window length

 Intuition:
 We are allowed to flip at most k zeros → so window is valid while
 number of zeros ≤ k.

 Pattern:
 expand → make window invalid (zeros > k)
 shrink → make window valid again
 update max length

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

class Solution {
    public static int longestOnes(int[] nums, int k) {

        int start = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int end = 0; end < nums.length; end++) {

            // Count zeros in current window
            if (nums[end] == 0) {
                zeroCount++;
            }

            // Shrink window if zeros exceed k
            while (zeroCount > k) {

                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            // Update maximum valid window length
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,0,1,1};
        int k = 2;
        int result = longestOnes(nums, k);
        System.out.println(result);
    }
}
