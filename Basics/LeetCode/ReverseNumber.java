package Basics.LeetCode;
import java.util.Scanner;

/*
 LeetCode Problem: Reverse Integer
 Approach:
 - Extract digits using modulo and division
 - Build reversed number step by step
 - Check for integer overflow before updating the result

 Edge Case:
 - Return 0 if reversed number overflows 32-bit signed integer range

 Time Complexity: O(d)   // d = number of digits
 Space Complexity: O(1)
*/

public class ReverseNumber {
    public static int reverse(int x) {
        boolean isNegative = x < 0;
        x = Math.abs(x);
        int rev = 0;
        
        while (x != 0) {
            int digit = x % 10;

            // Check for overflow before updating rev
            if (rev > Integer.MAX_VALUE / 10 ||
               (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 ||
               (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            rev = rev*10 + digit;
            x /= 10;
        }
        return isNegative ? -rev : rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        int result = reverse(num); 
        System.out.println("The reverse of number " + num + " is " + result);
        sc.close();
    }
}
