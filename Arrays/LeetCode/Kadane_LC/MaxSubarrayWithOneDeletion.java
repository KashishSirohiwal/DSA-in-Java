package Arrays.LeetCode.Kadane_LC;

/*
Problem: Maximum Subarray Sum with One Deletion

Idea:
- We want the maximum sum of a contiguous subarray, but we can delete at most one element.
- This requires tracking two states:
    1. dp0[i] → maximum subarray sum ending at index i with no deletion (classic Kadane).
    2. dp1[i] → maximum subarray sum ending at index i with one deletion allowed.
- Transition:
    * dp0[i] = max(arr[i], dp0[i-1] + arr[i])
    * dp1[i] = max(dp0[i-1], dp1[i-1] + arr[i])
- dp0[i-1] means we delete arr[i] itself (bridge across it).
- dp1[i-1] + arr[i] means we extend a subarray where deletion already happened earlier.

Technique Used:
- Dynamic Programming with two states (no deletion vs. one deletion).
- Iterate through the array once, updating dp0, dp1, and global result.

Time Complexity: O(n)
Space Complexity: O(n) (can be optimized to O(1) using variables).
*/

/*
Important Note:
- dp0 tracks the best sum ending at i without deletion.
- dp1 tracks the best sum ending at i with one deletion used.
- result keeps track of the global maximum across all indices.
- Edge cases:
    * If all numbers are negative, the answer is the least negative element.
    * If deletion is not beneficial, dp0 alone gives the answer.
*/

class MaxSubarrayOneDeletion {
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int[] dp0 = new int[n]; // no deletion
        int[] dp1 = new int[n]; // one deletion
        dp0[0] = arr[0];
        dp1[0] = arr[0];
        int result = arr[0]; // global maximum

        for (int i = 1; i < n; i++) {
            // Kadane without deletion
            dp0[i] = Math.max(arr[i], dp0[i-1] + arr[i]);

            // Kadane with one deletion
            dp1[i] = Math.max(dp0[i-1], dp1[i-1] + arr[i]);

            // Update global maximum
            result = Math.max(result, Math.max(dp0[i], dp1[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, -1, 5};
        int maxSum = maximumSum(arr);
        System.out.println("Maximum Subarray Sum with One Deletion: " + maxSum);
    }
}
