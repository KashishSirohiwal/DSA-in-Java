package Hashing.LeetCode;
import java.util.*;

/*
Problem: Find All Anagrams in a String (LeetCode 438)

Idea:
- An anagram is just a rearrangement of characters.
- Build a frequency map for p (target signature).
- Use a sliding window of length p.length() over s.
- Maintain a frequency map for the current window.
- At each step:
    * Add the new character entering the window.
    * Remove the old character leaving the window.
    * Compare windowMap with pMap.
    * If equal -> record starting index.

Technique Used:
- Sliding window + HashMap for frequency counts.

Time Complexity: O(n * alphabet) (map comparison per step)
Space Complexity: O(alphabet) (maps store character frequencies)
*/

public class FindAllAnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Frequency map for p
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        // Frequency map for current window
        Map<Character, Integer> windowMap = new HashMap<>();
        int windowSize = p.length();

        // Initialize first window
        for (int i = 0; i < windowSize; i++) {
            char c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }
        if (windowMap.equals(pMap)) result.add(0);

        // Slide the window
        for (int i = windowSize; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - windowSize);

            // Add new char
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);

            // Remove outgoing char
            windowMap.put(oldChar, windowMap.get(oldChar) - 1);
            if (windowMap.get(oldChar) == 0) windowMap.remove(oldChar);

            // Compare maps
            if (windowMap.equals(pMap)) result.add(i - windowSize + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbabdacb";
        String p = "cab";
        List<Integer> indices = findAnagrams(s, p);
        System.out.println("Anagram indices: " + indices);
    }
}