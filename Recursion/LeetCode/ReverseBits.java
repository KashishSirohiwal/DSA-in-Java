package Recursion.LeetCode;

/*
Problem: 190. Reverse Bits

Statement: Reverse bits of a given 32-bit unsigned integer.

Example:
Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000

Idea:
 - Normally solved with a loop shifting bits.
 - Recursive approach:
     * Base case: if n == 0 → return 0.
     * Recursive step:
         - Take last bit (n & 1).
         - Place it at position (31 - index).
         - Recurse on n >> 1 with index+1.

Technique Used: Recursion + Bit Manipulation

Time Complexity: O(32) = O(1)
Space Complexity: O(32) recursion stack = O(1)
*/

public class ReverseBits {
    public int reverseBits(int n) {
        return reverse(n, 0);
    }

    private int reverse(int n, int index) {
        if (index == 32) return 0; // base case
        int bit = (n & 1) << (31 - index);
        return bit | reverse(n >>> 1, index + 1);
    }
}