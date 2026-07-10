package Recursion.LeetCode;

/*
Problem: Splitting a String Into Descending Consecutive Values

Idea:
- Use recursion to explore all possible ways to split the string into consecutive descending values.
- For each split, check if the next number is exactly one less than the previous number.
- If a valid split is found, return true; otherwise, continue exploring other splits.

Technique: Recursion + Backtracking

Time Complexity: O(2^n) - In the worst case, we may explore all possible splits of the string.
Space Complexity: O(n) - The recursion stack can go as deep as the length of the string in the worst case.
*/

public class LC1849 {
    public boolean splitString(String s) {
        return backtrack(s, 0, -1);
    }

    private boolean backtrack(String s, int index, long prev) {
        // Base case: If we have reached the end of the string and have at least one valid split
        if (index == s.length()) {
            return prev != -1; // Ensure that we have at least one number in the split
        }

        long current = 0;
        for (int i = index; i < s.length(); i++) {
            // Build the current number from the substring
            current = current * 10 + (s.charAt(i) - '0');

            // If this is the first number, we can take it without any checks
            if (prev == -1) {
                if (backtrack(s, i + 1, current)) {
                    return true;
                }
            } else {
                // Check if the current number is exactly one less than the previous number
                if (current == prev - 1) {
                    if (backtrack(s, i + 1, current)) {
                        return true;
                    }
                }
            }

            // If the current number exceeds the previous number, we can break early
            if (prev != -1 && current >= prev) {
                break;
            }
        }
        return false;
    }
}