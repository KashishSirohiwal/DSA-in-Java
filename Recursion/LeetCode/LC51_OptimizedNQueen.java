package Recursion.LeetCode;
import java.util.*;

/*
Problem: N-Queens

Idea:
 - Use backtracking to place queens on the board.
 - For each row, try placing a queen in each column and check if it's safe using additional arrays to track columns and diagonals.
 - If it's safe, place the queen and move to the next row.
 - If we reach the last row, we found a solution and add it to the answer list.
 - Backtrack by removing the queen and trying the next column.

Technique Used: Backtracking + Optimization using additional arrays for column and diagonal checks.

Time Complexity: O(N!) in the worst case, where N is the number of queens (or size of the board).
Space Complexity: O(N^2) for the board and O(N) for the recursion stack in the worst case, 
                  plus O(N) for the additional arrays used for column and diagonal checks.

Why it is better than the brute force approach:
 - The previous approach checks for safety by iterating through the board, which takes O(N) time for each placement.
 - This optimized approach uses additional arrays to track the columns and diagonals, allowing for O(1) time complexity for safety checks, making it more efficient.
*/

public class LC51_OptimizedNQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Arrays to track occupied columns and diagonals
        boolean[] column = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        boolean[] rightDiagonal = new boolean[2 * n - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, ans, column, leftDiagonal, rightDiagonal);
        return ans;
    }

    private void solve(char[][] board, int row, List<List<String>> ans, boolean[] column, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if (row == board.length) {
            List<String> current = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (!column[col] && !leftDiagonal[row-col+ board.length-1] && !rightDiagonal[row+col]) {
                board[row][col] = 'Q';
                // Mark the column and diagonals as occupied
                column[col] = true;
                leftDiagonal[row-col+ board.length-1] = true;
                rightDiagonal[row+col] = true;
                
                solve(board, row + 1, ans, column, leftDiagonal, rightDiagonal);

                board[row][col] = '.';
                // Unmark the column and diagonals
                column[col] = false;
                leftDiagonal[row - col + board.length - 1] = false;
                rightDiagonal[row + col] = false;
            }
        }
    }
}
