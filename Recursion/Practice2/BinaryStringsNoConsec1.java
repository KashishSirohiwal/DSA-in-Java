package Recursion.Practice2;

/*
Problem: Generate Binary Strings with No Two Consecutive 1s

Statement:
 - Given an integer n, generate all binary strings of length n.
 - Constraint: No two consecutive '1's are allowed.

Example:
Input: n = 3
Output:
000
001
010
100
101

Idea:
 - Use recursion with backtracking.
 - At each position, place either '0' or '1'.
 - Constraint check:
     * '0' is always valid.
     * '1' is valid only if the previous character is not '1'.
 - Base case: when position == n, print the string.

Technique Used:
Recursion + Constraint Checking

Time Complexity: O(2^n) (branches pruned by constraint)
Space Complexity: O(n) recursion stack
*/

public class BinaryStringsNoConsec1 {
    public static void binaryStrings(int n, int position, char[] current) {
        if (position == n) {
            System.out.println(new String(current));
            return;
        }

        // choice 1: place '0'
        current[position] = '0';
        binaryStrings(n, position + 1, current);

        // choice 2: place '1' (only if previous is not '1')
        if (position == 0 || current[position - 1] != '1') {
            current[position] = '1';
            binaryStrings(n, position + 1, current);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        char[] current = new char[n];
        binaryStrings(n, 0, current);
    }
}