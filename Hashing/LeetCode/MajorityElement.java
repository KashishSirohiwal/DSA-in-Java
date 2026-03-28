package Hashing.LeetCode;

import java.util.HashMap;

/*
Problem: Majority Element (LeetCode 169)

Idea:
- Use a HashMap to count frequency of each element.
- Majority element is the one that appears more than n/2 times.
- Iterate nums, update frequency, and check if count > n/2.

Technique Used:
- Hashing (HashMap for frequency).
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n) {
                return num; // majority found
            }
        }
        return -1; // should never happen (problem guarantees majority exists)
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 2};

        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);
    }
}
