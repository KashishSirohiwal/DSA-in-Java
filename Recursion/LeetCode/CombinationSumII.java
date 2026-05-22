import Recursion.LeetCode;

/*
Problem: 40. Combination Sum II

Statement:
 - Given a collection of candidate numbers (candidates) and a target number (target),
   find all unique combinations in candidates where the candidate numbers sum to target.
 - Each number in candidates may only be used once in the combination.
 - The solution set must not contain duplicate combinations.

Example:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6],[1,2,5],[1,7],[2,6]]

Idea:
 - Sort the array to group duplicates together.
 - Use backtracking to build combinations.
 - At each recursion depth, skip duplicates with:
       if (i > start && candidates[i] == candidates[i-1]) continue;
 - Pass i+1 into recursion to ensure each element is used at most once.
 - Prune when sum + candidates[i] > target.

Technique Used:
Backtracking + Duplicate Skip

Time Complexity: O(2^n) in worst case (output sensitive).
Space Complexity: O(n) recursion stack + output list.
*/

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, int start, List<List<Integer>> res, List<Integer> temp) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (sum + candidates[i] > target) break;

            temp.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}