package Recursion.LeetCode;
import java.util.*;

/*
Problem: N-Queens

Idea:
 - Use backtracking to place queens on the board.
 - For each row, try placing a queen in each column and check if it's safe.
 - If it's safe, place the queen and move to the next row.
 - If we reach the last row, we found a solution and add it to the answer list.
 - Backtrack by removing the queen and trying the next column.

Technique Used: Backtracking + Brurte Force

Time Complexity: O(N!) in the worst case, where N is the number of queens (or size of the board).
Space Complexity: O(N^2) for the board and O(N) for the recursion stack in the worst case.
*/

public class LC51_NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, ans);
        return ans;
    }

    private void solve(char[][] board, int row, List<List<String>> ans) {
        // Base case: If all queens are placed, add the current board configuration to the answer list
        if (row == board.length) {
            List<String> current = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place queen
                solve(board, row + 1, ans); // Recur to place queens in the next row
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Check upper column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0  && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
