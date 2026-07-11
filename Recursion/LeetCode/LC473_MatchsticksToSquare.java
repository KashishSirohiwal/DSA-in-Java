package Recursion.LeetCode;

/*
Problem: Matchsticks to Square

Idea:
- Sort the matchsticks in descending order to optimize the backtracking process.
- Target length for each side of the square is the total length of matchsticks divided by 4.
- Use backtracking to try to form each side of the square by adding matchsticks.
- Keep track of which matchsticks have been used in the current combination to avoid using the same matchstick multiple times.
- Prune the search space by skipping matchsticks that have already been used or would exceed the target length for one side.

Technique: Backtracking + Recursion

Time Complexity: O(4^n) - In the worst case, we may explore all possible combinations of matchsticks to form the sides of the square.
Space Complexity: O(n) - The recursion stack can go as deep as the number of matchsticks in the worst case, and we also use a boolean array to keep track of used matchsticks.
*/

public class LC473_MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) sum += i;
        
        if (matchsticks.length < 4 || sum % 4 != 0) return false;
        
        // Each side of the square must be equal to the total length of matchsticks divided by 4
        int target = sum / 4;

        // Sort the matchsticks in descending order to optimize the backtracking process
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > target) return false;

        // Create a boolean array to keep track of which matchsticks have been used in the current combination
        boolean[] used = new boolean[matchsticks.length];
        return solve(matchsticks, target, 0, 0, 0, used);
    }

    private boolean solve(int[] matchsticks, int target, int index, int currentSum, int side, boolean[] used) {
        // If we have successfully formed 3 sides, the last side will automatically be formed
        if (side == 3) return true;

        // If the current sum of matchsticks equals the target length for one side, we can move on to form the next side
        if (currentSum == target) {
            return solve(matchsticks, target, 0, 0, side + 1, used);
        }

        for (int i = index; i < matchsticks.length; i++) {
            // Skip matchsticks that have already been used in the current combination
            if (used[i]) continue;

            // Skip duplicate matchsticks to avoid redundant combinations
            if (i > 0 && matchsticks[i] == matchsticks[i - 1] && !used[i - 1]) continue;
            
            // If adding the current matchstick exceeds the target length for one side, skip it
            if (currentSum + matchsticks[i] > target) continue;

            // Mark the current matchstick as used and attempt to add it to the current side
            used[i] = true;
            
            // Recursively attempt to form the current side with the added matchstick
            if (solve(matchsticks, target, i + 1, currentSum + matchsticks[i], side, used)) return true;
            
            // Backtrack: unmark the current matchstick as used and try the next possibility
            used[i] = false;
        }
        return false;
    }
}
