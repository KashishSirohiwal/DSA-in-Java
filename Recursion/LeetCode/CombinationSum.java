package Recursion.LeetCode;
import java.util.*;

/*
Problem: Combination Sum (LeetCode 39)

Statement:
 - Given an array of distinct positive integers candidates and a target integer target,
 - Return all unique combinations of candidates where the chosen numbers sum to target.
 - Each candidate may be used unlimited times.
 - Combinations in the result should be in non-decreasing order to avoid duplicates.

Idea:
 - Use backtracking to build partial combinations.
 - At each step iterate candidates starting from index start.
 - If you pick candidates[i], recurse with start = i to allow reuse of the same candidate.
 - Maintain running sum to detect when target is reached.
 - When running sum equals target, add a copy of the current list to the answer.

Technique Used:
Backtracking with running sum

Time Complexity:
 - Exponential in the worst case; depends on target and candidate values.
 - Output sensitive: complexity proportional to number of valid combinations.

Space Complexity:
 - O(target / min(candidates)) depth for recursion in worst case plus output storage.
*/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        // Optional optimization: sort to enable early pruning
        Arrays.sort(candidates);

        generateSum(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void generateSum(int[] candidates, int target, int start, int sum,
                             List<List<Integer>> ans, List<Integer> temp) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int cand = candidates[i];
            if (cand + sum > target) break; // pruning because array is sorted

            temp.add(cand);
            // pass i (not i+1) to allow reuse of the same candidate
            generateSum(candidates, target, i, sum + cand, ans, temp);
            // backtrack: remove last element
            temp.remove(temp.size() - 1);
        }
    }
}