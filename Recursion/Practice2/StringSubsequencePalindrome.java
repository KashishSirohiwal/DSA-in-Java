package Recursion.Practice2;
import java.util.*;

/*
Given a string s, return all possible palindromic subsequences of the string.

Example :
Input: s = "aba"
Output: ["a","b","a","aba"]

Complexity Analysis:
Time Complexity: O(2^n), where n is the length of the input string. 
Space Complexity: O(2^n), as we are storing all possible palindromic subsequences in the result list.
*/

public class StringSubsequencePalindrome {
    // Backtracking to generate subsequences
    public static void backtrack(String s, int index, StringBuilder current, List<String> res) {
        // base case: reached end of string
        if (index == s.length()) {
            if (current.length() > 0 && isPalindrome(current)) {
                res.add(current.toString());
            }
            return;
        }

        // choice 1: include s.charAt(index)
        current.append(s.charAt(index));
        backtrack(s, index + 1, current, res);
        current.deleteCharAt(current.length() - 1);

        // choice 2: exclude s.charAt(index)
        backtrack(s, index + 1, current, res);
    }

    // helper to check palindrome
    private static boolean isPalindrome(CharSequence sb) {
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), res);

        System.out.println("Palindromic subsequences of \"" + s + "\":");
        for (String sub : res) {
            System.out.println(sub);
        }
    }
}