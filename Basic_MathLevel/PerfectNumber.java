package Basic_MathLevel;

/*
Problem: LeetCode 507. Perfect Number

Example:
Input: num = 28
Output: true

Idea:
 - A perfect number is a positive integer that is equal to the sum of its proper divisors (excluding itself).
 - To check if a number is perfect, we can calculate the sum of its proper divisors and compare it to the original number.
 - We can optimize the divisor calculation by only iterating up to the square root of the number, since divisors come in pairs.

Technique Used: 
 - Iteration to find divisors and calculate their sum.

Time Complexity: O(sqrt(n)) where n is the input number, since we only iterate up to the square root.
Space Complexity: O(1) since we are using a constant amount of space to store the sum and loop variables.
*/

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false; // Perfect numbers are greater than 1

        int sum = 1; // Start with 1, which is a proper divisor
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i; // Add the divisor
                if (i != num / i) { // Add the complementary divisor if it's different
                    sum += num / i;
                }
            }
        }

        return sum == num; // Check if the sum of divisors equals the number
    }
}