package Strings.LeetCode;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int sIdx = 0, eIdx = s.length() - 1;
        while (sIdx < eIdx) {
            char startChar = s.charAt(sIdx);
            char endChar = s.charAt(eIdx);

            if (!Character.isLetterOrDigit(startChar)) { // Skip non-alphanumeric characters like spaces and punctuation
                sIdx++;
            } 
            else if (!Character.isLetterOrDigit(endChar)) { 
                eIdx--;
            } 
            else {
                if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) { // Case-insensitive comparison
                    return false;
                }
                sIdx++;
                eIdx--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String testStr = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(testStr); 
        System.out.println("Is the string a palindrome? " + result);

    }
}
