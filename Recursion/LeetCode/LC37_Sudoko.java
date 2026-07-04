package Recursion.LeetCode;

/*
Problem: Sudoku Solver

Idea:
 - Use backtracking to fill the empty cells in the Sudoku board.
 - For each empty cell, try placing digits from '1' to '9' and check if it's valid.
 - If valid, place the digit and recursively attempt to solve the rest of the board.
 - If a solution is found, return true; otherwise, backtrack and try the next digit.

Technique Used: Backtracking 

Time Complexity: O(9^(N)), where N is the number of empty cells. 
                 In the worst case, we may try all 9 digits for each empty cell.
Space Complexity: O(N) for the recursion stack, where N is the number of empty cells
*/

public class LC37_Sudoko {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Iterate through each cell in the board to find an empty cell (denoted by '.')
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                // If the cell is empty, try placing digits from '1' to '9'
                if(board[i][j]=='.') {
                    for (char d = '1'; d <= '9'; d++) {
                        // Check if placing the digit d in cell (i, j) is valid
                        if(isValid(board, i, j, d)) {
                            board[i][j] = d; // Place the digit

                            // Recursively attempt to solve the rest of the board
                            if (solve(board)) {
                                return true;
                            }

                            // If placing d doesn't lead to a solution, backtrack and try the next digit
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char d) {
        // Check if placing digit d in cell (row, col) is valid according to Sudoku rules

        // Check the row for the same digit
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == d) return false;
        }

        // Check the column for the same digit
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == d) return false;
        }

        // Check the 3x3 sub-box for the same digit
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == d) return false;
            }
        }
        return true;
    }
}