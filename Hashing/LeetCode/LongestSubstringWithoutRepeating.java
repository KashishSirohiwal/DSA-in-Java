package Hashing.LeetCode;
import java.util.*;

/*
Problem: Longest Substring Without Repeating Characters (LeetCode 3)

Idea:
- Use a sliding window to maintain a substring without duplicates.
- HashMap stores the last index of each character.
- When a duplicate is found:
    * Move the start pointer to max(start, lastIndex+1).
    * This ensures the window always contains unique characters.
- Update maxLen at each step.

Technique Used:
- Sliding window + HashMap (character -> last seen index).

Time Complexity: O(n)
Space Complexity: O(alphabet size)
*/
public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If character seen before, move start
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            // Update last index of c
            map.put(c, i);

            // Update max length
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abab";

        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s));
    }
}
