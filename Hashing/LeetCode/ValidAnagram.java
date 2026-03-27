package Hashing.LeetCode;

import java.util.HashMap;

/*
Problem: Valid Anagram (LeetCode 242)

Idea:
- Count frequency of each character in string s.
- Decrease frequency for each character in string t.
- If all counts return to zero, then s and t are anagrams.

Technique Used:
- Hashing (HashMap for character frequency).
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        // Count frequencies from s
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Subtract frequencies using t
        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) < 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagram(s, t);
        System.out.println("Are they anagrams? " + result);
    }
}
