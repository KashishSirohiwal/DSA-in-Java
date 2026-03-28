package Hashing.LeetCode;

import java.util.HashMap;

/*
Problem: Isomorphic Strings (LeetCode 205)

Idea:
- Use two HashMaps:
    * map1: maps characters from s -> t
    * map2: maps characters from t -> s
- For each index:
    * If mapping exists, check consistency.
    * If not, create new mapping.
- If any conflict arises, return false.

Technique Used:
- Hashing (two-way mapping).
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1) && map1.get(c1) != c2) return false;
            if (map2.containsKey(c2) && map2.get(c2) != c1) return false;

            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        boolean result = isIsomorphic(s, t);
        System.out.println("Are they isomorphic? " + result);

    }
}