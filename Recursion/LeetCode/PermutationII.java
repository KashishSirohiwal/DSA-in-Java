package Recursion.LeetCode;
import java.util.*;

/*
Problem: 47. Permutations II

Statement:
 - Given a collection of numbers, nums, that might contain duplicates.
 - Return all possible unique permutations in any order.

Example:
Input: nums = [1,1,2]
Output: [[1,1,2],[1,2,1],[2,1,1]]

Idea:
 - Sort the array to group duplicates together.
 - Use backtracking to generate permutations.
 - At each recursion step:
     * Swap the current element with each candidate.
     * Skip duplicates: if nums[i] == nums[j] and i != j, avoid reusing.
 - When start == nums.length, we have a complete permutation.

Technique Used:
Backtracking + Duplicate Skipping (via HashSet at each level)

Time Complexity: O(n * n!)
Space Complexity: O(n) recursion stack + output list
*/

public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
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

        Set<Integer> seen = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (seen.contains(nums[i])) continue; // skip duplicates at this level
            seen.add(nums[i]);

            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}