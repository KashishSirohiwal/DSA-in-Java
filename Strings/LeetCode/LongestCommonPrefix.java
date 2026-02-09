package Strings.LeetCode;
import java.util.Scanner;

/*
Problem: Longest Common Prefix
Given an array of strings, find the longest common prefix string amongst them. If there is no common prefix, return an empty string "".

Idea:
1. Start with the first string as the initial prefix.
2. Iterate through the remaining strings and check if they start with the current prefix.
3. If a string does not start with the prefix, shorten the prefix by removing the last character and check again.
4. Continue this process until we find a common prefix or the prefix becomes empty.

Technique Used:
- Use the indexOf method to check if the current string starts with the prefix.

Time Complexity: O(S) where S is the sum of all characters in all strings (in the worst case, we compare all characters).
Space Complexity: O(1) for the prefix variable, but O(S) for the input array of strings.

*/

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // Initialize prefix to the first string in the array
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // Check if the current string starts with the prefix
                prefix = prefix.substring(0, prefix.length() - 1); // Shorten the prefix by removing the last character
                if (prefix.isEmpty()) { // If the prefix becomes empty, there is no common prefix
                    return "";
                }
            }
        }
        return prefix; // Return the longest common prefix found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        String result = longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + result);
        sc.close();
    }
}
