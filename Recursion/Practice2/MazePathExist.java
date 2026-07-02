package Recursion.Practice2;

/*
Problem: Check if a path exists in a maze from the top-left corner to the bottom-right corner.

Idea:
 - Use recursion to explore all possible paths in the maze.
 - Keep track of visited cells to avoid cycles.
 - Base case: If we reach the bottom-right corner, return true.
 - If we hit a wall (1) or go out of bounds, return false.
 - Explore all four possible directions (down, up, right, left).

Technique Used: Recursion + Backtracking

Time Complexity: O(4^(m*n)) in the worst case, where m is the number of rows and n is the number of columns.
Space Complexity: O(m*n) for the visited array and recursion stack in the worst case.
*/

public class MazePathExist {
    public static boolean pathExists(int[][] maze, int row, int col, boolean[][] visited) {
        int m = maze.length;
        int n = maze[0].length;
        
        // Base case: destination reached
        if (row == m - 1 && col == n - 1 && maze[row][col] == 0) {
            return true;
        }
        
        // Invalid cell check
        if (row < 0 || col < 0 || row >= m || col >= n) return false;
        if (maze[row][col] == 1 || visited[row][col]) return false;
        
        // Mark visited
        visited[row][col] = true;
        
        // Explore neighbors (down, up, right, left)
        if (pathExists(maze, row + 1, col, visited)) return true;
        if (pathExists(maze, row - 1, col, visited)) return true;
        if (pathExists(maze, row, col + 1, visited)) return true;
        if (pathExists(maze, row, col - 1, visited)) return true;

        // Backtrack
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        MazePathExist mazeSolver = new MazePathExist();
        int[][] maze = {
            {0, 0, 1, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 0},
            {1, 1, 1, 0}
        };
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        boolean result = mazeSolver.pathExists(maze, 0, 0, visited);
        System.out.println("Path exists: " + result);
    }
}