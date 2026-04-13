package Binary_Search.LeetCode;    

/*
 Problem: 410. Split Array Largest Sum

 Idea:
 - We want to split nums[] into k contiguous subarrays.
 - Goal: minimize the largest subarray sum.
 - Search space = [max(nums), sum(nums)].
 - Use Binary Search on Answer Space:
   * mid = candidate largest sum.
   * Check feasibility with greedy function isMax().
   * If feasible -> try smaller (high = mid - 1).
   * If not feasible -> try larger (low = mid + 1).

 Technique Used:
 Binary Search + Greedy Feasibility Check

 Steps:
 1. Initialize low = max element, high = sum of array.
 2. Binary search between low and high.
 3. Use isMax() to check if mid is feasible.
 4. Update answer accordingly.
 5. Return minimized largest sum.

 Time Complexity: O(n log(sum(nums)))
 Space Complexity: O(1)
*/

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        // low = max element, high = sum of array
        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isMax(nums, k, mid)) {
                ans = mid; // feasible -> try smaller
                high = mid - 1;
            } else {
                low = mid + 1; // not feasible -> try larger
            }
        }
        return ans;
    }

    // Greedy feasibility check
    private boolean isMax(int[] nums, int k, int mid) {
        int count = 1; // number of subarrays formed
        int runningSum = 0; // sum of current subarray

        for (int num : nums) {
            if (runningSum + num > mid) {
                // start new subarray
                count++;
                runningSum = num; // new subarray starts with this element
                if (count > k) return false; // too many subarrays
            } else {
                runningSum += num; // keep adding to current subarray
            }
        }
        return true; // feasible within k subarrays
    }
}