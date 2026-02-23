package Arrays.LeetCode.Sliding_Window_LC;

/*
 LeetCode Problem: Minimum Size Subarray Sum

 Approach (Variable Size Sliding Window):
 - Expand the window by moving `end` and keep adding to sum
 - When sum ≥ target:
       update minimum length
       shrink the window from the left to find a smaller valid subarray
 - Continue this process for the entire array

 Why Variable Sliding Window?
 - We need the smallest subarray, not a fixed size
 - Window grows and shrinks dynamically

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {

            // Expand the window
            sum += nums[end];

            // Shrink the window while condition is satisfied
            while (sum >= target) {

                minLen = Math.min(minLen, end - start + 1);

                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int target = 7;
        System.out.println("Smallest subarray length: " + minSubArrayLen(target, arr));
    }
}