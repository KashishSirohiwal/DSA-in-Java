package Recursion.Practice2;

/*
Problem: Tower of Hanoi (Count Moves)

Statement:
 - Given n disks and three rods (source, destination, auxiliary).
 - Return the total number of moves required to transfer all disks from source to destination.
 - Verify that total moves = 2^n - 1.

Example:
Input: n = 3
Output: 7

Idea:
 - Base case: if n == 1 → only one move.
 - Recursive case:
     * Move (n-1) disks from source → auxiliary.
     * Move nth disk from source → destination.
     * Move (n-1) disks from auxiliary → destination.
 - Total moves = moves(n-1) + 1 + moves(n-1).

Technique Used:
Recursion + Mathematical Verification

Time Complexity: O(2^n)
Space Complexity: O(n) recursion stack
*/

public class TowerOfHanoiCount {
    public static int hanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            return 1; // only one move
        }

        int leftMoves = hanoi(n - 1, source, auxiliary, destination);
        int rightMoves = hanoi(n - 1, auxiliary, destination, source);

        return leftMoves + 1 + rightMoves;
    }

    public static void main(String[] args) {
        int n = 3;
        int totalMoves = hanoi(n, 'S', 'D', 'A');
        int formulaMoves = (int) Math.pow(2, n) - 1;

        System.out.println("Total moves (recursive): " + totalMoves);
        System.out.println("Formula (2^n - 1): " + formulaMoves);
        System.out.println(totalMoves == formulaMoves ? "Verified!" : "Mismatch!");
    }
}