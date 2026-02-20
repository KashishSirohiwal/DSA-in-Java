package Arrays.LeetCode.Sliding_Window_LC;

/*
/*
 LeetCode Problem: Maximum Average Subarray I

 Approach (Fixed Size Sliding Window):
 - Compute sum of first k elements (initial window)
 - Slide the window by:
       add next element
       remove the element leaving the window
 - Track the maximum window sum
 - Return maxSum / k as the maximum average

 Why Sliding Window?
 - Avoid recalculating sum for every subarray
 - Reduces time complexity from O(n*k) → O(n)

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MaxAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0.0;

        // Sum of first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // Slide the window 
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k]; 
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = findMaxAverage(nums, k);
        System.out.println("The max average subarray value : " + result); 
    }
}
