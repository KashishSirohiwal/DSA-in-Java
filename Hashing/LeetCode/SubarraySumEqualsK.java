package Hashing.LeetCode;
import java.util.HashMap;

/*
Problem: Subarray Sum Equals K (LeetCode 560)

Idea:
- We need to count the number of continuous subarrays whose sum equals k.
- Use prefix sums and a HashMap to track how many times each prefix sum has occurred.
- For each new prefix sum, check if (prefixSum - k) exists in the map.
  * If yes, add its frequency to the count (multiple subarrays can end here).
- Update the map with the current prefix sum.

Technique Used:
- Prefix sum with HashMap.
- Frequency counts (values in HashMap can be > 1 if prefix sums repeat).

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // HashMap to store prefixSum → frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: prefixSum = 0 occurs once

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if (prefixSum - k) exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Update frequency of current prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2};
        int k = 3;
        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + " = " + result);
    }
}
