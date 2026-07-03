package Recursion.LeetCode;

/*
Problem: Word Search

Idea:
 - Use backtracking to search for the word in the board.
 - For each cell, if it matches the first character of the word, start a DFS to check if the entire word can be formed.
 - Mark the cell as visited by changing its value temporarily and explore all four directions (up, down, left, right).
 - If the word is found, return true; otherwise, backtrack and restore the cell's original value.

Technique Used: Backtracking + Depth-First Search (DFS)

Time Complexity: O(M * N * 4^L), where M is the number of rows, N is the number of columns, and L is the length of the word. 
                 In the worst case, we may explore all four directions for each character in the word.
Space Complexity: O(L) for the recursion stack, where L is the length of the word
*/

public class LC79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Iterate through each cell in the board to find the starting point for the DFS
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // If the first character matches, start DFS
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, row, col, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        // Base case: If the entire word is found, return true
        if (index == word.length()) return true;

        // Check for out-of-bounds or if the cell is already visited or does not match the current character
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        // Check if the current cell is already visited or does not match the current character
        if (board[row][col] == '#') return false;

        // Check if the current cell matches the current character in the word
        if (board[row][col] != word.charAt(index)) return false;

        // Mark the cell as visited by changing its value to a special character (e.g., '#')
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four directions (up, down, left, right) to find the next character in the word
        boolean found = dfs(board, row - 1, col, word, index + 1) ||
                        dfs(board, row + 1, col, word, index + 1) ||
                        dfs(board, row, col - 1, word, index + 1) ||
                        dfs(board, row, col + 1, word, index + 1);

        // Backtrack: Restore the cell's original value
        board[row][col] = temp;

        // Return whether the word was found in any of the four directions
        return found;
    }
}