package Strings.LeetCode;
/*
Problem: Length of Last Word

Idea:
- Start from the end of the string and count characters until we encounter a space.
- If we encounter a space after counting characters, we can stop.

Technique Used:
- Iterate through the string in reverse and count characters of the last word.

Time Complexity: O(n) where n is the length of the string.
Space Complexity: O(1) since we are using only a constant amount of space for counting.
*/

public class LengthOfLastWord {
    public static int lengthOfLastWord(String str) {
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ' && count > 0) { // If we encounter a space after counting characters, we can stop
                break;
            } else if (str.charAt(i) != ' ') { // Count characters of the last word
                count++;
            }
        }
        return count;
    }    

    public static void main(String[] args) {
        String str = "Hello World";
        int result = lengthOfLastWord(str);
        System.out.println("Count of last word : " + result); 
    }
}
