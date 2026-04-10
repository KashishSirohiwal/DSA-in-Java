package Binary_Search.LeetCode;

/*
 Problem: Search in Rotated Sorted Array (LeetCode 33)

 Idea:
 - Array is sorted but rotated at some pivot.
 - At each step, one half is always sorted.
 - Detect which half is sorted and check if target lies in that half.
 - Shrink search space accordingly.

 Technique Used:
 Binary Search with sorted-half detection

 Steps:
 1. Initialize low = 0, high = nums.length - 1.
 2. While low <= high:
    - Compute mid = low + (high - low) / 2.
    - If nums[mid] == target → return mid.
    - If left half is sorted (nums[low] <= nums[mid]):
        - If target lies in [nums[low], nums[mid]) -> high = mid - 1.
        - Else → low = mid + 1.
    - Else (right half is sorted):
        - If target lies in (nums[mid], nums[high]] -> low = mid + 1.
        - Else → high = mid - 1.
 3. Return -1 if not found.

 Time Complexity: O(log n)
 Space Complexity: O(1)
*/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}