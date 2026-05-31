package Recursion.LeetCode;

/*
Problem: LeetCode 704. Binary Search

Example:
Input: arr = [-1,0,3,5,9,12], target = 9
Output: 4

Idea:
 - Use a recursive approach to perform binary search on the sorted array.
 - Calculate the middle index and compare the middle element with the target.
 - If they match, return the middle index. If the middle element is greater than the target, search in the left half; otherwise, search in the right half.

Technique Used:
 - Recursion to divide the search space in half at each step.

Time Complexity: O(log n) where n is the number of elements in the array, since we are halving the search space at each step.
Space Complexity: O(log n) due to the recursive call stack in the worst case (when the target is not found and we search through all levels of recursion).
*/

public class BinarySearchRecursive {
    public int binarySearch(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }
    public int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) return -1; // Target not found
        
        int mid = left + (right - left) / 2; // Avoids overflow
        
        if (arr[mid] == target) {
            return mid; // Target found
        } 
        else if (arr[mid] > target) {
            return binarySearchHelper(arr, target, left, mid - 1); // Search in the left half
        } 
        else {
            return binarySearchHelper(arr, target, mid + 1, right); // Search in the right half
        }
    }
}
