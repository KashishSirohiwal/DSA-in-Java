package Arrays.LeetCode.Prefix_Sum_LC;

/*
 LeetCode Problem: Subarray Sum Equals K

 Approach (Prefix Sum + Brute Force):
 - Build a prefix sum array where:
       prefix[i] = sum of elements from index 0 to i-1
 - For any subarray (start → end):
       subarray sum = prefix[end] - prefix[start]
 - If subarray sum == k → increment count

 Why prefix sum?
 - It allows O(1) subarray sum calculation

 Time Complexity: O(n^2)
 Space Complexity: O(n) 
*/

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int count = 0;

        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i+1] = nums[i] + prefix[i];
        }

        for (int str = 0; str < n ; str++) {
            for (int end = str + 1; end <= n; end++) {
                if (prefix[end] - prefix[str] == k) {
                    count++;
                }
            }
        } 

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,1};
        int k = 3;
        int result = subarraySum(nums, k);
        System.out.println("The total no of subarray which sum to " + k + " : " + result);
    }
}
