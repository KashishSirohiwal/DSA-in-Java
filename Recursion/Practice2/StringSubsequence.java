package Recursion.Practice2;
import java.util.*;

/*
Given a string s, return all possible subsequences of the string.
A subsequence of a string is a new string that is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example :
Input: s = "abc"
Output: ["","a","b","c","ab","ac","bc","abc"]

Complexity Analysis:
Time Complexity: O(2^n), where n is the length of the input string.
Space Complexity: O(2^n), as we are storing all possible subsequences in the result list.
*/

public class StringSubsequence {
    public static void backtrack(String s, int index, StringBuilder current, List<String> res) {
        // base case: reached end of string
        if (index == s.length()) {
            res.add(current.toString());
            return;
        }

        // choice 1: include s.charAt(index)
        current.append(s.charAt(index));
        backtrack(s, index + 1, current, res);
        current.deleteCharAt(current.length() - 1);

        // choice 2: exclude s.charAt(index)
        backtrack(s, index + 1, current, res);
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), res);

        System.out.println("All subsequences of \"" + s + "\":");
        for (String sub : res) {
            System.out.println(sub);
        }
    }
}