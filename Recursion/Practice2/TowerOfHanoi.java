package Recursion.Practice2;
    
/*
Problem: Tower of Hanoi

Statement:
 - Given n disks and three rods (source, destination, auxiliary).
 - Print the sequence of moves to transfer all disks from source to destination.
 - Only one disk can be moved at a time.
 - A disk can only be placed on top of a larger disk.

Example (n = 3):
Move disk 1 from S to D
Move disk 2 from S to A
Move disk 1 from D to A
Move disk 3 from S to D
Move disk 1 from A to S
Move disk 2 from A to D
Move disk 1 from S to D

Idea:
 - Base case: if n == 1, directly move that disk from source → destination.
 - Recursive case:
     * Move (n-1) disks from source → auxiliary.
     * Move nth disk from source → destination.
     * Move (n-1) disks from auxiliary → destination.

Technique Used:
Recursion

Time Complexity: O(2^n)
Space Complexity: O(n) recursion stack
*/

public class TowerOfHanoi {
    public static void hanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move n-1 disks from source to auxiliary
        hanoi(n - 1, source, auxiliary, destination);

        // Step 2: Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from auxiliary to destination
        hanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n, 'S', 'D', 'A');
    }
}