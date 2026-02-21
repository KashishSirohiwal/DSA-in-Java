package Arrays.LeetCode.Sliding_Window_LC;

/*
 LeetCode Problem: Maximum Number of Vowels in a Substring of Given Length

 Approach (Fixed Size Sliding Window):
 - Count vowels in the first window of size k
 - Slide the window one character at a time:
       add the new character
       remove the character going out of the window
 - Track the maximum vowel count seen in any window

 Why Sliding Window?
 - Avoid recalculating count for every substring
 - Reduces time complexity from O(n*k) → O(n)

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MaximumNumberOfVowelsInASubstring {
    public static int maxVowels(String s, int k) {
        char[] charr = s.toCharArray();
        int c = 0; // current vowel count

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(charr[i])) c++;
        }

        int mc = c; // max vowels seen so far

        // Slide the window
        for (int i = k; i < charr.length; i++) {
            if (isVowel(charr[i])) c++;          // add new char
            if (isVowel(charr[i - k])) c--;      // remove old char
            mc = Math.max(mc, c);                // update max
        }

        return mc;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int result = maxVowels(s, k);
        System.out.println("The maximum number of vowels in a substring : " + result);
    }
}
