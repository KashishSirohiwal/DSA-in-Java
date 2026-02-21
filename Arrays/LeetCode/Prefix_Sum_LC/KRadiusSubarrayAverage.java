package Arrays.LeetCode.Prefix_Sum_LC;
import java.util.Arrays;

/*
 LeetCode Problem: K Radius Subarray Averages

 Approach:
 - Use prefix sum to compute range sum in O(1)
 - For each valid center index j:
       window size = 2*k + 1
       subarray sum = prefix[j + k + 1] - prefix[j - k]
       average = sum / window size
 - Fill -1 for indices where a full window is not possible

 Why prefix sum?
 - Avoid recomputing sum for every window
 - Reduces time complexity from O(n * window) → O(n)

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class KRadiusSubarrayAverage {
    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // Default values

        // Build prefix sum
        long[] prefix = new long[n+1]; 
        for (int i = 0; i < n; i++) { 
            prefix[i+1] = prefix[i] + nums[i]; 
        }

        int window = 2 * k + 1;
        // Compute averages using prefix sums
        for (int j = k; j < n - k; j++) {
            long sum = prefix[j+k+1] - prefix[j-k];
            res[j] = (int)(sum / window);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;

        int[] result = getAverages(nums, k);
        System.out.println("The K radius average array : ");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
