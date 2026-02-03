package Recursion.LeetCode;
import java.util.Scanner;

/*
 LeetCode Problem: Fibonacci Number
 Approach:
 - Use recursive definition of Fibonacci
 - Base cases: fib(0) = 0, fib(1) = 1
 - Recursive relation: fib(n) = fib(n-1) + fib(n-2)

 Time Complexity: O(2^n)
 Space Complexity: O(n) (recursion stack)
*/
public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        int result = fib(number);
        System.out.println("The " + number + "th Fibonacci number is: " + result);
        sc.close();
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) return n;
        int f = fib(n-1) + fib(n-2);
        return f;
    }
}
