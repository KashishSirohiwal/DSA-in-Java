package Hashing.LeetCode;

import java.util.HashMap;

/*
Problem: First Unique Character in a String (LeetCode 387)

Idea:
- Use a HashMap to count frequency of each character.
- First pass: build frequency map.
- Second pass: iterate string again and return the index of the first character with frequency = 1.
- If none found, return -1.

Technique Used:
- Hashing (HashMap for frequency).
- Time Complexity: O(n)
- Space Complexity: O(1) (since only 26 lowercase letters)
*/

class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // First pass: count frequencies
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Second pass: find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";

        int result = firstUniqChar(s);
        System.out.println("Index of first unique character: " + result);
    }
}
