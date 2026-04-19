package Binary_Search.LeetCode;

/*
Problem: 153. Find Minimum in Rotated Sorted Array

Statement:
 - Given a rotated sorted array, find the minimum element.

Idea:
 - Use binary search to locate rotation point.
 - If nums[mid] > nums[high], min is in right half.
 - Else, min is in left half.

Technique Used:
Binary Search on Rotated Array

Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}