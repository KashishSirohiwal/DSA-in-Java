package Bubble_Sort.LeetCode;

/*
Problem: Minimum Difference Between Highest and Lowest of K Scores (LeetCode 1984)

Idea:
- Sort the array using Bubble Sort.
- For each window of size k, compute difference between max and min.
- Return the minimum difference.

Technique Used:
- Bubble Sort + Sliding Window.

Time Complexity: O(n^2) (bubble sort)
Space Complexity: O(1)
*/

public class MinimumDifferenceHighestLowest {
    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        int k = 2;
        System.out.println("Minimum difference: " + minimumDifference(nums, k)); // Output: 2
    }
}
