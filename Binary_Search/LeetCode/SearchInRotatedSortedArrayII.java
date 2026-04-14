package Binary_Search.LeetCode;

/*
 Problem: 81. Search in Rotated Sorted Array II

 Statement:
 - Given a rotated sorted array nums (may contain duplicates) and an integer target,
   return true if target exists in nums, otherwise false.

 Difference from LeetCode 33:
 - LeetCode 33: No duplicates → always one half strictly sorted → O(log n).
 - LeetCode 81: Duplicates allowed → duplicates can break strict ordering.
   Worst case: O(n) when duplicates force linear scan.

 Idea:
 - Modified binary search:
   * If nums[mid] == target → return true.
   * If nums[left] == nums[mid] == nums[right] → shrink search space (left++, right--).
   * Otherwise, check which half is sorted and move accordingly.

 Technique Used:
 Binary Search with duplicate handling

 Time Complexity: O(log n) average, O(n) worst case
 Space Complexity: O(1)
*/

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;

            // Handle duplicates
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}