package Bubble_Sort.LeetCode;

/*
Problem: Array Partition (LeetCode 561)

Idea:
- Pair up the array elements after sorting.
- The sum of min(ai, bi) for each pair is maximized when the array is sorted.
- So, sort the array using Bubble Sort and take every alternate element.

Technique Used:
- Bubble Sort + Greedy.

Time Complexity: O(n^2) (bubble sort)
Space Complexity: O(1)
*/

public class ArrayPartition {
    public static int arrayPairSum(int[] nums) {
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

        // Take every alternate element
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 8, 5};
        System.out.println("Max sum of pairs: " + arrayPairSum(nums));
    }
}
