package Hashing.LeetCode;

import java.util.HashMap;

/*
Problem: Word Pattern (LeetCode 290)

Idea:
- Split string s into words.
- Use two HashMaps:
    * map1: pattern char -> word
    * map2: word -> pattern char
- For each index:
    * If mapping exists, check consistency.
    * If not, create new mapping.
- Return false if any conflict arises.

Technique Used:
- Hashing (two-way mapping).
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (map1.containsKey(c) && !map1.get(c).equals(w)) return false;
            if (map2.containsKey(w) && map2.get(w) != c) return false;

            map1.put(c, w);
            map2.put(w, c);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean result = wordPattern(pattern, s);
        System.out.println("Does the string follow the pattern? " + result);
    }
}