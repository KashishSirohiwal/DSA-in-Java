package Hashing.LeetCode;

import java.util.HashMap;

/*
Problem: Find the Difference (LeetCode 389)

Idea:
- Count frequency of characters in s.
- Subtract frequency using t.
- The character with count = 1 is the extra one.

Technique Used:
- Hashing (HashMap for frequency).
- Time Complexity: O(n)
- Space Complexity: O(1) (since only 26 lowercase letters)
*/

class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) - 1);
            if (freq.get(c) < 0) {
                return c; // extra character found
            }
        }
        return ' '; // fallback, should never happen
    }

    public static void main(String[] args) {
        String s = "acbd";
        String t = "abdce";

        char result = findTheDifference(s, t);
        System.out.println("Extra character: " + result);
    }
}