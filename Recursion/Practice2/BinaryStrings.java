package Recursion.Practice2;

/*
Problem: Generate all binary strings of length n

Statement:
 - Given an integer n, generate all binary strings of length n.
 - Each string consists only of '0' and '1'.

Example:
Input: n = 3
Output:
000
001
010
011
100
101
110
111

Idea:
 - Use recursion with backtracking.
 - At each position, place either '0' or '1'.
 - When position == n, print the current string.

Technique Used:
Recursion + Backtracking

Time Complexity: O(2^n)
Space Complexity: O(n) recursion stack
*/

public class BinaryStrings {
    public static void binaryStrings(int n, int position, char[] current) {
        if (position == n) {
            System.out.println(new String(current));
            return;
        }

        // choice 1: place '0'
        current[position] = '0';
        binaryStrings(n, position + 1, current);

        // choice 2: place '1'
        current[position] = '1';
        binaryStrings(n, position + 1, current);
    }

    public static void main(String[] args) {
        int n = 3;
        char[] current = new char[n];
        binaryStrings(n, 0, current);
    }
}