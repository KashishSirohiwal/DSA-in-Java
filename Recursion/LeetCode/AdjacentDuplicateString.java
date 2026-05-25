package Recursion.LeetCode;

/*
Problem: 1047. Remove All Adjacent Duplicates In String

Example: 
Input: s = "abbaca"
Output: "ca"

Idea:
 - Use a StringBuilder as a stack to build the result.
 - Iterate through characters in s:
   - If current char matches last char in StringBuilder, remove last char (pop).
   - Else, append current char to StringBuilder (push).
 - At end, StringBuilder contains result with adjacent duplicates removed.

Technique Used:
 - Stack-like behavior using StringBuilder.

Time Complexity: O(n) where n is length of s.
Space Complexity: O(n) in worst case if no duplicates, O(1) if all duplicates.
*/

public class AdjacentDuplicateString {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1); // remove duplicate
            } else {
                sb.append(c); // push
            }
        }
        return sb.toString();
    }
}