package Recursion.LeetCode;
import java.util.Scanner;

/*
 LeetCode Problem: Power of Two
 Approach:
 - A number is power of two if it can be divided by 2 repeatedly
 - Base case: n == 1 → true
 - If n <= 0 or n is odd → false
 - Recursively check n / 2

 Time Complexity: O(log n)
 Space Complexity: O(log n) (recursion stack)
*/

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        boolean result = isPowerOfTwo(number);
        System.out.println(number + " is a power of two: " + result);
        sc.close();
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;   
        if (n <= 1 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2); 
    }
}
