package Recursion.LeetCode;

/*
Problem: LeetCode 17. Letter Combinations of a Phone Number

Example:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Idea:
 - Use a backtracking approach to generate all combinations of letters for the given digits.
 - Map each digit to its corresponding letters using a predefined mapping.
 - Recursively build combinations by appending letters for each digit and backtracking when necessary.

Technique Used:
 - Backtracking to explore all possible combinations of letters.

Time Complexity: O(4^n) where n is the length of the input digits (since the maximum number of letters for a digit is 4).
Space Complexity: O(n) for the recursion stack and the current combination being built.
*/

public class LetterCombination {
    private static final String[] mapping = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> res) {
        if (index == digits.length()) {
            res.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {   // ✅ FIXED
            current.append(c);
            backtrack(digits, index + 1, current, res);
            current.deleteCharAt(current.length() - 1);
        }
    }
}