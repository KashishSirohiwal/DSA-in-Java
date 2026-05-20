package Recursion.LeetCode;

/*
Problem: 31. Next Permutation
Statement:
 - Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 - If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 - The replacement must be in place and use only constant extra memory. 

Example:
Input: nums = [1,2,3]
Output: [1,3,2]

Idea:
 - Traverse from the end to find the first pair of indices (i, i+1) where nums[i] < nums[i+1]. This identifies the pivot.
 - If no such pair exists, reverse the entire array to get the lowest order.
 - If a pivot is found, traverse from the end again to find the first index j where nums[pivot] < nums[j].
 - Swap nums[pivot] and nums[j].
 - Reverse the subarray from pivot + 1 to the end to get the next permutation.

Technique Used:
 - Two-pointer + recursion

Time Complexity: O(n) for finding pivot and successor + O(n) for reversing = O(n)
Space Complexity: O(1) in-place
*/

public class NextPermutation {
        public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }
        
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1 ; i > pivot; i--) {
            if (nums[pivot] < nums[i]) {
                swap(nums, pivot, i);
                break;
            }
        }

        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}