package Strings.LeetCode;

/*
Problem: Valid Anagram

Idea:
- An anagram is a word formed by rearranging the letters of another word. To determine if two
  strings are anagrams, we can count the frequency of each character in both strings and compare the counts.
- We can use an integer array of size 26 to count the occurrences of each character (assuming only lowercase letters).

Approach:
1. Check if the lengths of the two strings are equal. If not, return false.
2. Create an integer array of size 26 to count the frequency of characters.
3. Iterate through both strings simultaneously:
    - For each character in the first string, increment the corresponding count in the charCount array.
    - For each character in the second string, decrement the corresponding count in the charCount array.
4. After processing both strings, check if all counts in the charCount array are zero. If they are, return true; otherwise, return false.

Time Complexity: O(n), where n is the length of the strings (since we iterate through both strings once).
Space Complexity: O(1) for the charCount array, as it has a fixed size of 26.
*/
public class ValidAnagram {
    public static boolean validAnagram(String s, String t) {
        int sl = s.length(); int tl = t.length();
        if (sl == tl) {
            int[] charCount = new int[26]; // Assuming only lowercase letters
            for (int i = 0; i < sl; i++) {
                charCount[s.charAt(i) - 'a']++; // Increment count for char in s
                charCount[t.charAt(i) - 'a']--; // Decrement count for char in t
            }
            for (int count : charCount) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "care";
        boolean result = validAnagram(s, t);
        System.out.println("Are the two strings anagrams? " + result);
    }
}