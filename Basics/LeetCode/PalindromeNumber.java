package Basics.LeetCode;
import java.util.Scanner;

/*
 LeetCode Problem: Palindrome Number
 Approach:
 - Negative numbers are not palindromes
 - Reverse the number using digit extraction
 - Compare reversed number with original

 Time Complexity: O(d)  // d = number of digits
 Space Complexity: O(1)
*/

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int original = x; 
        int rev = 0;
        while (x > 0) {
            int digit = x % 10;  
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev == original ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int x = sc.nextInt();
        boolean result = isPalindrome(x); 
        if (result) {
            System.out.println("The number " + x + " is palindrome");
        }
        else {
            System.out.println("The number " + x + " is not palindrome");
        }
        sc.close();
    }
}
