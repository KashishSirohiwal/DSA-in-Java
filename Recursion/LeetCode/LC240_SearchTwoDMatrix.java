package Recursion.LeetCode;

/*
Problem: 240. Search a 2D Matrix II

Idea: 
 - Start from the bottom-left corner of the matrix.
 - If the current value is equal to the target, return true.
 - If the current value is greater than the target, move up (decrease row).
 - If the current value is less than the target, move right (increase column).
 - Repeat until you find the target or go out of bounds.

Important Note:
 - Choosing the bottom-left corner is strategic because it allows us to eliminate 
   either a row or a column with each comparison, making the search efficient.
 - Choosing either top left or bottom right corners would not allow for this efficient elimination, 
   as moving in those directions does not consistently lead to a smaller or larger value.

Technique Used: Recursion

Time Complexity: O(m + n) where m is the number of rows and n is the number of columns.
Space Complexity: O(m + n) for the recursion stack in the worst case.
*/

public class LC240_SearchTwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return helper(matrix, rows - 1, 0, target);
    }

    private boolean helper(int[][] matrix, int row, int col, int target) {
        if (row < 0 || col >= matrix[0].length) return false;

        int val = matrix[row][col];

        if (val == target) {
            return true;
        } 
        else if (val > target) {
            return helper(matrix, row - 1, col, target);
        } 
        else {
            return helper(matrix, row, col + 1, target);
        }
    }
}