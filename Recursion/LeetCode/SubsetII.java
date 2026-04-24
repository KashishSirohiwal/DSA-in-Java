package Recursion.LeetCode;
import java.util.*;

/*
Problem: 90. Subsets II

Statement:
 - Given an integer array nums that may contain duplicates.
 - Return all possible subsets (the power set).
 - The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Idea:
 - Sort the array to group duplicates together.
 - Use backtracking to generate subsets.
 - At each recursion step:
     * Include nums[index] -> recurse.
     * Exclude nums[index] -> skip duplicates before recursing.
 - This ensures we don’t generate duplicate subsets.

Technique Used:
Backtracking + Duplicate Skipping

Time Complexity: O(n * 2^n)
Space Complexity: O(n) recursion stack + output list
*/

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}