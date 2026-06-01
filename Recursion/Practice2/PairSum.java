package Recursion.Practice2;

/*
Idea :
- We used two levels :
    1. Outer recursion to fix the first element (index i).
    2. Inner recursion to find all partners for the fixed element (index j > i).
- This way, we avoid duplicate pairs and ensure we only check each pair once.

Time Complexity : O(n^2) - we check each pair once
Space Complexity : O(n) - recursion stack depth
*/

public class PairSum {
    // Outer recursion: fix index i
    public static void outRec(int[] arr, int target, int i) {
        if (i >= arr.length) return;  // base case

        // Inner recursion: find partners for arr[i]
        intRec(arr, target, i, i + 1);

        // Move i forward
        outRec(arr, target, i + 1);
    }

    // Inner recursion: scan j > i
    public static void intRec(int[] arr, int target, int i, int j) {
        if (j >= arr.length) return;  // base case

        if (arr[i] + arr[j] == target) {
            System.out.println("(" + arr[i] + ", " + arr[j] + ")");
        }

        // Move j forward
        intRec(arr, target, i, j + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        outRec(arr, target, 0);
    }
}