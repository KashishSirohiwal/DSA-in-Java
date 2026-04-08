package Binary_Search.LeetCode;

/*
Problem: Binary Search (LeetCode 704)

Idea:
 - Given a sorted array of integers and a target value, return the index of the target if found.
 - If not found, return -1.
 - Use binary search to efficiently locate the target.

Technique Used:
Binary Search (Divide and Conquer)

Steps:
1. Initialize two pointers: low = 0, high = nums.length - 1.
2. While low <= high:
 - Compute mid = low + (high - low) / 2.
 - If nums[mid] == target → return mid.
 - If nums[mid] < target → search right half (low = mid + 1).
 - Else → search left half (high = mid - 1).
3. If loop ends without finding target → return -1.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class BinarySearch {
        public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // target found
            } else if (nums[mid] < target) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }
        return -1; // target not found
    }
}