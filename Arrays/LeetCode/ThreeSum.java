package Arrays.LeetCode;
import java.util.*;

/*
 Problem: 3Sum (LeetCode - Medium)

 Task:
 -----
 Given an integer array nums, return all unique triplets
 [nums[i], nums[j], nums[k]] such that: nums[i] + nums[j] + nums[k] == 0

 Conditions:
 - The solution set must not contain duplicate triplets.
 - Order of triplets does not matter.

 Technique Used:
 Sorting + Two Pointer Technique

 Why Sorting?
 - Enables two-pointer approach.
 - Makes duplicate handling easy.
 - Allows logical pointer movement based on sum.

 Time Complexity: O(n^2)
 Space Complexity: O(1) extra (excluding result list)
*/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix the first element one by one
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            // Step 3: Two-pointer search for remaining two elements
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {

                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers
                    left++;
                    right--;

                    // Skip duplicate values for left pointer
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    // Skip duplicate values for right pointer
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < 0) {
                    // Sum too small → increase it
                    left++;
                }
                else {
                    // Sum too large → decrease it
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> triplets = ts.threeSum(nums);

        System.out.println("Unique Triplets that sum to zero:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
        sc.close();
    }
}
