package Arrays.LeetCode.Kadane_LC;
import java.util.Scanner;

/*
Problem: Maximum Sum Circular Subarray

Idea:
- We want to find the contiguous subarray with the largest sum in a circular array.
- Two cases exist:
    1. Normal case (no wrap): Use Kadane’s algorithm to find the maximum subarray sum.
    2. Wrap-around case: The maximum subarray may span the end and the beginning.
       Trick: Instead of directly finding this, compute totalSum - minSum.
       Removing the minimum subarray leaves the maximum wrap-around subarray.

Technique Used:
- Dynamic Programming (Kadane’s Algorithm) applied twice:
    * Once to find max subarray sum (maxSum).
    * Once to find min subarray sum (minSum).
- Compare maxSum with (totalSum - minSum) to handle wrap-around.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Important Note:
- currentMax represents the maximum sum of a subarray ending at the current index.
- maxSum keeps track of the overall maximum sum found so far.
- currentMin represents the minimum sum of a subarray ending at the current index.
- minSum keeps track of the overall minimum sum found so far.
- totalSum is the sum of all elements in the array.
- If all numbers are negative, we return maxSum directly (otherwise totalSum - minSum would incorrectly give 0).
*/

class MaxCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int currentMax = nums[0], currentMin = nums[0];
        int maxSum = nums[0], minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i]; // Add current element to total sum

            // Kadane for maximum subarray
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane for minimum subarray
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }

        // Edge case: if all numbers are negative, return maxSum
        if (maxSum < 0) return maxSum;

        // Otherwise, return the maximum of normal and wrap-around case
        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements : ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter element values : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxCircularSum = maxSubarraySumCircular(nums);
        System.out.println("Maximum Circular Subarray Sum: " + maxCircularSum);

        sc.close();
    }
}
