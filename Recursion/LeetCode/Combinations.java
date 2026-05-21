package Recursion.LeetCode;
import java.util.*;

/*
Problem: 77. Combinations

Statement:
 - Given two integers n and k.
 - Return all possible combinations of k numbers chosen from the range [1, n].

Example:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

Idea:
 - Use backtracking to build combinations.
 - At each recursion step:
     * Add the next number to the current list.
     * Recurse with updated start index.
     * Remove the number (backtrack).
 - Stop when current.size() == k → add to result.
 - Optimization: loop only until n - (k - current.size()) + 1
   (ensures enough numbers remain to complete a combination).

Technique Used:
Backtracking + Pruning

Time Complexity: O(C(n, k)) (number of combinations)
Space Complexity: O(k) recursion stack + output list
*/

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}