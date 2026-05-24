import java.util.*;

/*
Problem : LC 22. Generate Parentheses

Approach : Backtracking + Pruning

Idea :
- We can only add '(' if we still have opens left to add (open < n).
- We can only add ')' if it won’t break validity (close < open).
- We build the string recursively, and once we reach a complete string of length 2*n, we add it to the result.

Time Complexity : O(4^n / sqrt(n)) - Catalan number growth
Space Complexity : O(C.n) - recursion stack
*/

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", n, 0, 0, result);
        return result;
    }

    // Backtracking function
    private void backtrack(String current, int n, int open, int close, List<String> result) {
        // Base case: when the string length reaches 2*n, it's complete
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add '(' if we still have opens left
        if (open < n) {
            backtrack(current + "(", n, open + 1, close, result);
        }

        // Add ')' if it won’t break validity
        if (close < open) {
            backtrack(current + ")", n, open, close + 1, result);
        }
    }
}