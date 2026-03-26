package Hashing.LeetCode;

import java.util.HashSet;

/*
Problem: Contains Duplicate (LeetCode 217)

Idea:
- Use a HashSet to track seen numbers.
- For each number:
    * Try to add it to the set.
    * If add() returns false, it means the number was already present => duplicate found.
- Return true if duplicate exists, otherwise false.

Technique Used:
- Hashing (HashSet).
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n)) {
                return true; // duplicate found
            }
        }
        return false; // no duplicates
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        boolean result = containsDuplicate(nums);
        System.out.println("Contains Duplicate? " + result);
    }
}
