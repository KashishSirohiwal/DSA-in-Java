package Recursion.LeetCode;
import java.util.*;

/*
Problem: 216. Combination Sum III

Statement:
 - Find all possible combinations of k numbers that add up to n.
 - Only numbers 1 through 9 are allowed.
 - Each number may be used at most once.
 - Return all valid combinations.

Example:
Input: k = 3, n = 7
Output: [[1,2,4]]

Idea:
 - Backtracking from 1 to 9.
 - At each step, choose a number, recurse with i+1 (single use).
 - Stop when current size == k and sum == n.
 - Prune when sum > n or size > k.

Technique Used:
Backtracking with constraints (length k, sum n)

Time Complexity: O(C(9,k)) worst case.
Space Complexity: O(k) recursion depth + output list.
*/

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, 1, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int k, int target, int start, int sum,
                           List<Integer> current, List<List<Integer>> res) {
        // base case: valid combination
        if (sum == target && current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        // prune: if sum exceeds target or size exceeds k
        if (sum > target || current.size() > k) return;

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(k, target, i + 1, sum + i, current, res);
            current.remove(current.size() - 1);
        }
    }
}