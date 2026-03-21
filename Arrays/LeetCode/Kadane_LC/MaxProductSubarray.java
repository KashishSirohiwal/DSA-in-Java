package Arrays.LeetCode.Kadane_LC;
import java.util.Scanner;

/*
Problem: Maximum Product Subarray

Idea:
- We want to find the contiguous subarray with the largest product.
- Unlike Kadane’s Algorithm (which tracks only max sums), here we must track both
  maximum and minimum products at each step because:
    * A negative number can flip the minimum product into a maximum.
    * A positive number can extend the maximum product.
- At each step, we decide whether to:
    * Start fresh with nums[i]
    * Extend the previous max product
    * Extend the previous min product

Technique Used:
- Dynamic Programming with two variables (maxPro, minPro)
- Iterate through the array once, updating maxPro, minPro, and result at each step.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxPro = nums[0];   // maximum product of a subarray ending at the current index.
        int minPro = nums[0];   // minimum product of a subarray ending at the current index.
        int result = nums[0];   // Global maximum product

        for (int i = 1; i < nums.length; i++) {
            int temp = maxPro; // Store old max before updating

            // Update maxPro: choose the best among starting fresh, extending maxPro, or extending minPro
            maxPro = Math.max(nums[i], Math.max(maxPro * nums[i], minPro * nums[i]));

            // Update minPro: choose the worst among starting fresh, extending old maxPro, or extending minPro
            minPro = Math.min(nums[i], Math.min(temp * nums[i], minPro * nums[i]));

            // Update global result
            result = Math.max(result, maxPro);
        }

        return result;
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

        int maxProductValue = maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + maxProductValue);

        sc.close();
    }
}

