package Arrays.LeetCode.Prefix_Sum_LC;

/*
 LeetCode Problem: Left and Right Sum Differences

 Approach:
 - Build prefix sum array where leftSum[i] stores sum of elements before index i
 - Build suffix sum array where rightSum[i] stores sum of elements after index i
 - For each index, compute absolute difference:
       |leftSum[i] - rightSum[i]|

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

public class LeftAndRightSumDifference {
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];   // Stores prefix sums: sum of elements to the left of index i
        int[] rightSum = new int[n];  // Stores suffix sums: sum of elements to the right of index i
        int[] answer = new int[n];    // Stores the final absolute differences

        // Build prefix sums (leftSum[i] = sum of nums[0..i-1])
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        // Build suffix sums (rightSum[i] = sum of nums[i+1..n-1])
        for (int i = n-2; i >= 0; i--) {
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        // Compute absolute difference between left and right sums for each index
        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;  // Return the result array
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, 8, 3};
        int[] result = leftRightDifference(nums);
        System.out.print("The difference in leftSum and RightSum : ");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
