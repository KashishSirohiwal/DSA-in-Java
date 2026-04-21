package Recursion.LeetCode;
import java.util.*;

/*
Problem: 78. Subsets

Statement:
 - Given an integer array nums of unique elements.
 - Return all possible subsets (the power set).
 - The solution set must not contain duplicate subsets.

Idea:
 - Use backtracking (DFS).
 - At each index, we have two choices:
     * Include nums[index] in the current subset.
     * Exclude nums[index] from the current subset.
 - When we reach the end, add the current subset to result.

Technique Used:
Backtracking (DFS recursion)

Time Complexity: O(n * 2^n) (each subset built in O(n))
Space Complexity: O(n) recursion stack + output list
*/

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Include nums[index]
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);

        // Exclude nums[index]
        current.remove(current.size() - 1);
        backtrack(nums, index + 1, current, result);
    }
}