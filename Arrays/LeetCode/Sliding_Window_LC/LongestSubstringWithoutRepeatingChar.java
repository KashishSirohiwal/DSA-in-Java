package Arrays.LeetCode.Sliding_Window_LC;

/*
 LeetCode Problem: Longest Substring Without Repeating Characters

 Approach (Variable Sliding Window):
 - Use a frequency array to track characters in current window
 - Expand window by moving `end`
 - If a character repeats → shrink window from the left
 - Maintain the maximum window length with all unique characters

 Pattern:
 expand → until invalid
 shrink → until valid
 update answer

 Time Complexity: O(n)
 Space Complexity: O(1)   // fixed size array (256)
*/

public class LongestSubstringWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];   // stores frequency of characters
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {

            char current = s.charAt(end);
            freq[current]++;

            // If duplicate found → shrink window
            while (freq[current] > 1) {

                freq[s.charAt(start)]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Longest length: " + result);
    }
}