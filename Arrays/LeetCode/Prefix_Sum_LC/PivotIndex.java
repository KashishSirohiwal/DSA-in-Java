package Arrays.LeetCode.Prefix_Sum_LC;

/*
 LeetCode Problem: Find Pivot Index

 Pivot index = index where:
 sum of elements on the left == sum of elements on the right

 Approach:
 1. Compute total sum of the array
 2. Traverse the array and keep track of leftSum
 3. For each index:
      rightSum = totalSum - leftSum - current element
 4. If leftSum == rightSum → pivot found

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class PivotIndex {

    public static int pivotIndex(int[] nums) {

        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        int leftSum = 0;

        // Step 2: Traverse and check pivot condition
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1; // No pivot index found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 5, 6};
        System.out.println("The pivot index is: " + pivotIndex(arr));
    }
}