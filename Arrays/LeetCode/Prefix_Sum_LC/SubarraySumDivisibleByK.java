package Arrays.LeetCode.Prefix_Sum_LC;

/*
 LeetCode Problem: Subarray Sums Divisible by K

 Approach (Prefix Sum + Brute Force):
 - Build a prefix sum array where:
       prefix[i] = sum of first i elements
 - For any subarray (start → end):
       subarray sum = prefix[end] - prefix[start]
 - If subarray sum % k == 0 → it is divisible by k → increase count

 Why prefix sum?
 - Allows O(1) subarray sum calculation instead of O(n)

 Time Complexity: O(n^2)
 Space Complexity: O(n)
*/

public class SubarraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int count = 0;

        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i+1] = nums[i] + prefix[i];
        }

        for (int str = 0; str < n ; str++) {
            for (int end = str + 1; end <= n; end++) {
                int sum = prefix[end] - prefix[str];
                if (sum % k == 0) {
                    count++;
                }
            }
        } 
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        int result = subarraysDivByK(nums, k);
        System.out.println("The total no of subarray which is divisble by " + k + " : " + result);
    }
}
