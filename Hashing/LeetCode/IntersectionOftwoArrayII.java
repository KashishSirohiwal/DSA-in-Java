package Hashing.LeetCode;

import java.util.HashMap;
import java.util.ArrayList;

/*
Problem: Intersection of Two Arrays II (LeetCode 350)

Idea:
- Use a HashMap to store frequency of elements in nums1.
- Iterate nums2:
    * If element exists in map with count > 0, add to result and decrement count.
- Convert result list to array and return.

Technique Used:
- Hashing (HashMap for frequency).
- Time Complexity: O(n + m)
- Space Complexity: O(min(n, m))
*/

class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequencies in nums1
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        // Check nums2 against freq map
        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                resultList.add(num);
                freq.put(num, freq.get(num) - 1); // decrement count
            }
        }

        // Convert result list to array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 1};
        int[] nums2 = {2, 2, 3};

        int[] result = intersect(nums1, nums2);
        System.out.print("Intersection with duplicates: ");
        for (int num : result) System.out.print(num + " ");
    }
}
