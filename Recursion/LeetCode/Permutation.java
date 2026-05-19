package Recursion.LeetCode;
import java.util.*;

/*
Problem: 46. Permutations

Statement:
 - Given an array nums of distinct integers.
 - Return all possible permutations.

Example:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Idea:
 - Use backtracking to generate permutations.
 - At each recursion step:
     * Fix one element at the current position.
     * Swap it with each candidate from start → end.
     * Recurse for the next position.
     * Backtrack (swap back).
 - When start == nums.length, we have a complete permutation.

Technique Used:
Backtracking + Swapping

Time Complexity: O(n * n!)
Space Complexity: O(n) recursion stack + output list
*/

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int x : nums) perm.add(x);
            result.add(perm);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i); // choose
            backtrack(nums, start + 1, result); // explore
            swap(nums, start, i); // undo
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}