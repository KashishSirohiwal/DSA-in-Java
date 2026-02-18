package Arrays.LeetCode.Prefix_Sum_LC;

/*
LeetCode Problem: Find Middle Index In Array

 Middle index = index where:
 sum of elements on the left == sum of elements on the right

 Approach:
 1. Compute total sum of the array
 2. Traverse the array and keep track of leftSum
 3. For each index:
      rightSum = totalSum - leftSum - current element
 4. If leftSum == rightSum → middle index found

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class MiddleIndex {
    public static int findMiddleIndex(int[] nums) {
        int totalsum = 0;
        for (int x: nums) totalsum += x;
        int leftsum = 0;

        for (int i=0; i<nums.length; i++) {
            int rightsum = totalsum - leftsum - nums[i];

            if (leftsum == rightsum) return i;

            leftsum += nums[i];
        }
        return -1;
    } 

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 2, 5, 6};
        System.out.println("The pivot index is: " + findMiddleIndex(arr));
    }
}
