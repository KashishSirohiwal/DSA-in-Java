package Hashing.LeetCode;
import java.util.HashMap;

/*
Problem: Contains Duplicate II (LeetCode 219)

Idea:
- Use a HashMap to store each number and its latest index.
- For each number:
    * If it already exists in the map, check the distance between current index and stored index.
    * If the distance <= k, return true (duplicate within range).
    * Otherwise, update the index in the map.
- If no such pair found, return false.

Technique Used:
- Hashing (HashMap).
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i); // update latest index
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4};
        int k = 2;

        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println("Contains Nearby Duplicate? " + result);
    }
}
