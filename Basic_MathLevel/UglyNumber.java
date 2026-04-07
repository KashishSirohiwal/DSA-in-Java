package Basic_MathLevel;

/*
Problem: Ugly Number (LeetCode 263)

Idea:
- An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
- To check if n is ugly:
1. If n <= 0, return false (not valid).
2. Divide n by 2 repeatedly until it is no longer divisible.
3. Divide n by 3 repeatedly until it is no longer divisible.
4. Divide n by 5 repeatedly until it is no longer divisible.
5. If the final result is 1, then n is ugly.

Technique Used:
Prime Factor Reduction

- Iteratively divide n by allowed prime factors (2, 3, 5).
- If after reduction n becomes 1, it means all prime factors were from {2,3,5}.

Time Complexity: O(log n) (division reduces n quickly)
Space Complexity: O(1)
*/

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        // Divide out factors of 2
        while (n % 2 == 0) n /= 2;
        // Divide out factors of 3
        while (n % 3 == 0) n /= 3;
        // Divide out factors of 5
        while (n % 5 == 0) n /= 5;

        // If reduced to 1, it's ugly
        return n == 1;
    }
}