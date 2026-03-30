package Hashing.LeetCode;
import java.util.HashMap;

/*
Problem: Continuous Subarray Sum (LeetCode 523)

Idea:
- We need to check if there exists a continuous subarray of length ≥ 2
  whose sum is a multiple of k.
- Use prefix sums and modular arithmetic:
  * If two prefix sums have the same remainder modulo k,
    then the subarray between them has sum divisible by k.
- Store remainder -> earliest index in a HashMap.
- If the same remainder appears again at a later index,
  and the subarray length >= 2, return true.

Technique Used:
- Prefix sum with modulo.
- HashMap to store earliest index of each remainder.
- Base case: map.put(0, -1) ensures subarrays starting at index 0 are handled.

Time Complexity: O(n)
Space Complexity: O(min(n, k)) (since remainders are bounded by k)
*/

public class ContinousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case: remainder 0 seen at index -1

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum % k;

            if (map.containsKey(rem)) {
                // ensure subarray length ≥ 2
                if (i - map.get(rem) >= 2) return true;
            } else {
                // store earliest index for this remainder
                map.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 2};
        int k = 8;

        boolean result = checkSubarraySum(nums, k);
        System.out.println("Has subarray with sum multiple of " + k + "? " + result);
    }
}