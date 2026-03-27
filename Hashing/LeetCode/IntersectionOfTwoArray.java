package Hashing.LeetCode;

import java.util.HashSet;

/*
Problem: Intersection of Two Arrays (LeetCode 349)

Idea:
- Store elements of the smaller array in a HashSet.
- Iterate over the larger array and check membership.
- Add common elements to a result set (to ensure uniqueness).
- Convert result set to array.

Technique Used:
- Hashing (HashSet).
- Time Complexity: O(n + m)
- Space Complexity: O(min(n, m))
*/

class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert result set to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 4};
        int[] nums2 = {2, 3, 1};

        int[] result = intersection(nums1, nums2);
        System.out.print("Intersection: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
