package Hashing.LeetCode;

import java.util.HashMap;

/*
Problem: Two Sum

Idea:
- Use a HashMap to store numbers and their indices.
- For each number, check if (target - number) exists in the map.
- If yes, return indices.
- If not, put the number in the map.

Technique Used:
- Hashing (HashMap).
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return null; // if no solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 7, 5};
        int target = 9;

        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
