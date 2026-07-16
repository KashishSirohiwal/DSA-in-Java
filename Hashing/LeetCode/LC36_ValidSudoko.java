package Hashing.LeetCode;

/*
Problem: Valid Sudoku (LeetCode 36)

Idea:
- Use a HashSet to track the numbers seen in each row, column, and 3x3 box.
- For each number in the board, check if it has already been seen in the corresponding row  
  or column or box. If it has, return false.
- If we finish checking all cells without finding duplicates, return true.  

Technique Used: Hashing (HashSet for tracking seen numbers).

Time Complexity: O(1) - The board size is fixed (9x9), so the time complexity is constant.
Space Complexity: O(1) - The space used for the HashSet is also constant since the maximum number 
of unique entries is limited to 81 (9 rows * 9 columns).
*/

import java.util.HashSet;

public class LC36_ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        // Create sets to track seen numbers in rows, columns, and boxes
        HashSet<String> seen = new HashSet<>();

        // Iterate through each cell in the 9x9 Sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Get the current number in the cell
                char num = board[i][j];

                // If the cell is empty (represented by '.'), skip it
                if (num == '.') continue;
                
                // Check if the number has already been seen in the current row, column, or 3x3 box
                if (!seen.add(num + " in row " + i) ||
                    !seen.add(num + " in col " + j) ||
                    !seen.add(num + " in box " + i/3 + "-" + j/3)) {
                    return false;
                }
            }
        }
        return true;
    }
}