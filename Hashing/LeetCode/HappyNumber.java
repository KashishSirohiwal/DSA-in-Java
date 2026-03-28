package Hashing.LeetCode;

import java.util.HashSet;
import java.util.Scanner;

/*
Problem: Happy Number (LeetCode 202)

Idea:
- A number is happy if repeatedly replacing it with the sum of the squares of its digits eventually leads to 1.
- If the process falls into a cycle (never reaches 1), the number is not happy.
- We need to detect cycles in this transformation process.

Approaches:
1. HashSet:
   * Keep track of numbers seen so far.
   * If we encounter a repeat -> cycle detected -> not happy.
   * If we reach 1 -> happy number.

2. Floyd’s Cycle Detection (Tortoise and Hare):
   * Use slow and fast pointers to detect cycles without extra space.
   * If fast pointer reaches 1 -> happy.
   * If slow == fast (cycle detected) -> not happy.

Technique Used:
- Cycle detection (HashSet).
- Helper function to compute sum of squares of digits.

Time Complexity: O(log n) per transformation (digits processed).
Space Complexity: O(n) with HashSet, O(1) with Floyd’s cycle detection.
*/

class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false; // cycle detected
            }
            seen.add(n);

            n = sumOfSquares(n);
        }
        return true;
    }

    // Helper function to compute sum of squares of digits
    public static int sumOfSquares(int num) {
        int total = 0;
        while (num > 0) {
            int digit = num % 10;
            total += digit * digit;
            num /= 10;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean result = isHappy(n);
        System.out.println("Is Happy Number? " + result);

        sc.close();
    }
}
