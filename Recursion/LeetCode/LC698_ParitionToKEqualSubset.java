package Recursion.LeetCode;

/*
Problem: Partition to K Equal Sum Subsets

Idea:
 - Use backtracking to try to partition the array into k subsets with equal sum.
 - Calculate the total sum of the array and check if it is divisible by k. If not, return false.
 - Sort the array in descending order to optimize the backtracking process.
 - Use a boolean array to keep track of which elements have been used in the current subset.
 - Recursively try to build subsets, and if a subset reaches the target sum, move on to the next subset.

Technique Used: Backtracking + Optimization (sorting and skipping duplicates)

Time Complexity: O(k * 2^n), where n is the number of elements in the array. 
                 In the worst case, we may explore all possible combinations of elements for each subset.
Space Complexity: O(n) for the boolean array used to track used elements, 
                  plus O(k) for the recursion stack in the worst case.
*/

public class LC698_ParitionToKEqualSubset {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // If the total sum is not divisible by k, it's impossible to partition into k equal subsets
        if (sum % k != 0) return false;
        int target = sum / k;

        // Sort the array in descending order to optimize the backtracking process
        Arrays.sort(nums);
        // If the largest number is greater than the target sum, it's impossible to partition
        if (nums[nums.length - 1] > target) return false;

        boolean[] used = new boolean[nums.length];
        return solve(nums, used, 0, 0, k, target);
    }

    private boolean solve(int[] nums, boolean[] used, int start, int currentSum, int k, int target) {
        // If only one subset is left, the remaining numbers must form a valid subset
        if (k == 1) return true;

        // If the current subset reaches the target sum, move on to the next subset
        if (currentSum == target){
            return solve(nums, used, 0, 0, k - 1, target);
        }

        // Try to build the current subset by adding unused numbers
        for (int i = start; i < nums.length; i++) {
            // Skip used numbers and duplicates to avoid redundant work
            if (used[i]) continue;

            // Skip duplicates: if the current number is the same as the previous one and the previous one was not used, skip it
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

            // If adding the current number exceeds the target sum, skip it
            if (currentSum + nums[i] > target) continue;
            
            // Mark the current number as used and try to build the subset
            used[i] = true;

            if (solve(nums, used, i + 1, currentSum + nums[i], k, target)) {
                return true;
            }

            // Backtrack: unmark the current number and try the next one
            used[i] = false;
        }
        return false;
    }
}
