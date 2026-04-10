package Binary_Search.LeetCode;

/*
 Problem: Find First and Last Position of Element in Sorted Array (LeetCode 34)

 Idea:
 - Given a sorted array, we need to find the starting and ending index of a target value.
 - If target is not found, return [-1, -1].
 - Must achieve O(log n) runtime → use binary search.

 Technique Used:
 Binary Search (two passes)

 Steps:
 1. Use binary search to find the first occurrence of target.
 2. Use binary search to find the last occurrence of target.
 3. If target not found, return [-1, -1].
 4. Otherwise, return [firstIndex, lastIndex].

 Time Complexity: O(log n)
 Space Complexity: O(1)
*/

public class FindFirstAndLastPos {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return new int[]{-1, -1}; // target not found
        }
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    // Helper function to find first or last occurrence
    private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0, high = nums.length - 1;
        int bound = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    high = mid - 1; // keep searching left
                } else {
                    low = mid + 1;  // keep searching right
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bound;
    }
}