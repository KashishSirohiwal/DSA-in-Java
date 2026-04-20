package Basic_MathLevel;    
import java.util.*;

/*
 Problem: 18. 4Sum

 Statement:
 - Given an array nums of n integers and an integer target.
 - Find all unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     nums[a] + nums[b] + nums[c] + nums[d] == target.
 - Return the list of quadruplets without duplicates.

 Idea:
 - Sort the array to handle duplicates easily.
 - Fix two indices (i, j).
 - Use two pointers (l, r) to find remaining two numbers.
 - Skip duplicates for i, j, l, r to avoid repeated quadruplets.

 Technique Used:
 Sorting + Two Pointers + Duplicate Skipping

 Time Complexity: O(n^3)
 Space Complexity: O(1) extra (excluding output list)
*/

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}