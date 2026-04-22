package Basic_MathLevel;

/*
 Problem: 1015. Smallest Integer Divisible by K

 Statement:
 - Given an integer K.
 - Find the length of the smallest positive integer n consisting only of digit '1'
   (like 1, 11, 111, …) such that n is divisible by K.
 - If no such n exists, return -1.

 Idea:
 - We cannot build huge numbers directly (overflow).
 - Instead, simulate divisibility using modular arithmetic:
     * Start with remainder = 1 % K.
     * At each step, extend the number by one '1':
         remainder = (remainder * 10 + 1) % K.
     * If remainder becomes 0 → found answer (length).
     * If we loop more than K steps without hitting 0 → no solution.

 Technique Used:
 Modular arithmetic + cycle detection

 Time Complexity: O(K)
 Space Complexity: O(1)
*/

public class SmallestIntegerDivByK {
    public int smallestRepunitDivByK(int K) {
        int remainder = 1 % K;
        for (int length = 1; length <= K; length++) {
            if (remainder == 0) return length;
            remainder = (remainder * 10 + 1) % K;
        }
        return -1;
    }
}