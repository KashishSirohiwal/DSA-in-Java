package Arrays.Kadane_Algo;

/*
Problem: Maximum Absolute Sum of Any Subarray

Idea:
- The maximum absolute sum can come from either:
    1. The maximum subarray sum (positive side).
    2. The minimum subarray sum (negative side, whose absolute value might be larger).
- So we compute both using Kadane’s algorithm:
    * currentMax / maxSum for maximum subarray sum.
    * currentMin / minSum for minimum subarray sum.
- Final answer = max(maxSum, |minSum|).

Time Complexity: O(n)
Space Complexity: O(1)
*/

class MaxAbsoluteSum {
    public static int maxAbsoluteSum(int[] nums) {
        int currentMax = nums[0], maxSum = nums[0];
        int currentMin = nums[0], minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Kadane for maximum subarray sum
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane for minimum subarray sum
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        int[] nums = {3, -8, -1, 2, 4};

        int result = maxAbsoluteSum(nums);
        System.out.println("Maximum Absolute Sum of Any Subarray: " + result);
    }
}

