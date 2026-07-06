package Recursion.Practice2;

/*
Problem: Integer Partition

Technique Used: Backtracking

Idea:
 - Use backtracking to generate all possible partitions of the integer n.
 - Maintain a current partition and add it to the result list when the remaining value reaches 0.
 - Ensure that the next integer added to the current partition is greater than or equal to the last integer added to maintain non-decreasing order.

Time Complexity: O(2^n), where n is the integer to be partitioned. 
                 In the worst case, we may explore all possible combinations of integers that sum up to n.
Space Complexity: O(n) for the recursion stack and the current partition list, 
                  plus O(k) for the result list where k is the number of valid partitions found.
*/

public class IntegerPartition {
    private void solve(int remaining, int minimumAllowed, List<Integer> current, List<List<Integer>> ans) {
        if (remaining == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = minimumAllowed; i <= remaining; i++) {
            current.add(i);
            solve(remaining - i, i, current, ans);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> partition(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, 1, new ArrayList<>(), ans);
        return ans;
    }
}