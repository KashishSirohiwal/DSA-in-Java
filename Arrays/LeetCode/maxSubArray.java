package Arrays.LeetCode;
import java.util.Scanner;

/*
Problem: Maximum Subarray

Idea:
- We want to find the contiguous subarray with the largest sum. 
- We can use a dynamic programming approach where we keep track of the current sum and the maximum sum found so far.
- At each step, we decide whether to extend the current subarray or start a new subarray from the current element.
- currentSum = max(nums[i], currentSum + nums[i])
- maxSum = max(maxSum, currentSum)

Technique Used:
- Dynamic Programming (Kadane's Algorithm)
- Iterate through the array once, updating currentSum and maxSum at each step.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/*
Important Note:
- currentSum represents the maximum sum of a subarray that ends at the current index.
- maxSum keeps track of the overall maximum sum found so far.
- continuity is maintained by deciding whether to extend the current subarray or start a new one at each element.
*/

class maxSubArray {
    public static int maxsubArray(int[] nums) {
        int currentSum = nums[0]; // Initialize current sum to the first element
        int maxSum = nums[0]; // Initialize max sum to the first element
        for (int i = 1; i < nums.length; i++) {
            int extend = currentSum + nums[i]; // Potential new sum if we extend the current subarray
            currentSum = Math.max(nums[i], extend); // Decide whether to start a new subarray or extend the current one
            maxSum = Math.max(maxSum, currentSum); // Update max sum if the current sum is greater
        }
        return maxSum;
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

        int maxSum = maxsubArray(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum);

        sc.close();
    }
}