package Strings.LeetCode;

/* change this!
Problem: To Lower Case

Idea:
- Convert each uppercase character to lowercase by adding 32 to its ASCII value.
- Non-uppercase characters remain unchanged.

Technique Used:
- Iterate through the string and modify characters as needed.

Time Complexity: O(n)
Space Complexity: O(n) for the new string created from the character array.
*/

public class ToLowerCase {
    public static String toLowerCase(String str) {
        char[] charr = str.toCharArray();
        for (int i = 0; i < charr.length; i++) {
            if (charr[i] >= 'A' && charr[i] <= 'Z') {
                charr[i] = (char) (charr[i] + 32); // 32 is the difference between uppercase and lowercase in ASCII
            }
        }
        return new String(charr);
    }

    public static void main(String[] args) {
        String str = "Hello World!";
        String res = toLowerCase(str);
        System.out.println("Lowercase string: " + res);
    }
}