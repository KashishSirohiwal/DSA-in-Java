package Recursion.LeetCode;

/*
Problem: LC 491 - Non-Decreasing Subsequences

Idea:
 - Use backtracking to generate all possible subsequences of the given array.
 - Maintain a current subsequence and add it to the result list if its length is at least 2.
 - Use a HashSet to avoid duplicates in the current recursive call.
 - Ensure that the current number is greater than or equal to the last number in the current subsequence to maintain non-decreasing order.

Technique Used: Backtracking + HashSet for duplicate avoidance

Time Complexity: O(2^n), where n is the number of elements in the array. 
                 In the worst case, we may explore all possible combinations of elements.
Space Complexity: O(n) for the recursion stack and the current subsequence list, 
                  plus O(k) for the result list where k is the number of valid subsequences found.
*/

public class LC491_NonDecreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        solve(nums, 0, current, ans);
        return ans;
    }

    private void solve(int[] nums, int start, List<Integer> current, List<List<Integer>> ans) {
        // Base case: If the current subsequence has at least 2 elements, add it to the result list
        if (current.size() >= 2) {
            ans.add(new ArrayList<>(current));
        }

        // Use a HashSet to avoid duplicates in the current recursive call
        HashSet<Integer> used = new HashSet<>();
        
        for (int i = start; i < nums.length; i++) {
            // If the current number is already used in this recursive call, skip it
            if (used.contains(nums[i])) continue;
            // If the current number is less than the last number in the current subsequence, skip it to maintain non-decreasing order
            if (!current.isEmpty() && nums[i] < current.get(current.size() - 1)) continue;
            
            used.add(nums[i]);
            current.add(nums[i]);
            solve(nums, i + 1, current, ans);
            current.remove(current.size() - 1);
        }

    }
}
