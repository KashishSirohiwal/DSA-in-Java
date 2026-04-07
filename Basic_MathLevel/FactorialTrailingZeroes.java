package Basic_MathLevel;

/*
Problem: Factorial Trailing Zeroes (LeetCode 172)

Idea:
- Trailing zeroes in n! come from factors of 10.
- Each 10 = 2 × 5.
- Since there are always more factors of 2 than 5, 
the number of trailing zeroes depends only on the count of 5s.
- Count multiples of 5, 25, 125, ... until n.

Technique Used:
Mathematical Reduction (Counting Factors of 5)

- Divide n by 5 to count how many numbers contribute at least one factor of 5.
- Divide n by 25 to count extra factors from multiples of 25.
- Continue with higher powers of 5 until n becomes 0.

Time Complexity: O(log₅ n)
Space Complexity: O(1)
*/

class FactorialTrailingZeroes{
    public int trailingZeroes(int n) {
        int result = 0;

        // Count factors of 5
        while (n > 0) {
            n /= 5;
            result += n;
        }

        return result;
    }
}