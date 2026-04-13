package Binary_Search.LeetCode;

/*
 Problem: 1283. Find the Smallest Divisor Given a Threshold

 Idea:
 - We need the smallest divisor such that:
   sum(ceil(nums[i] / divisor)) ≤ threshold
 - Search space = [1, max(nums)]
 - Use Binary Search on Answer Space:
   * mid = candidate divisor
   * Check feasibility with isFeasible()
   * If feasible -> try smaller
   * If not feasible -> try larger

 Technique Used:
 Binary Search + Greedy Summation

 Time Complexity: O(n log(max(nums)))
 Space Complexity: O(1)
*/

public class FindSmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int i : nums) {
            high = Math.max(high, i);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(nums, threshold, mid)) {
                ans = mid;       // feasible → try smaller
                high = mid - 1;
            } else {
                low = mid + 1;   // not feasible → try larger
            }
        }
        return ans;
    }

    private boolean isFeasible(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int i : nums) {
            sum += Math.ceil((double)i / divisor);
        }
        return sum <= threshold;
    }
}