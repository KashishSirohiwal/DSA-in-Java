package Hashing.LeetCode;
import java.util.*;

/*
Problem: Longest Consecutive Sequence (LeetCode 128)

Idea:
- Use a HashSet for O(1) lookups.
- A number is the start of a sequence if (num - 1) is not in the set.
- From each start, count how long the streak goes (num+1, num+2, ...).
- Track the maximum streak length.

Fix:
- Iterate over the HashSet instead of the original array.
- This avoids duplicate numbers causing redundant checks.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // Put all numbers in a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        // Iterate over the set (unique numbers only)
        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                // Count consecutive streak
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                // Update max length
                maxLength = Math.max(maxLength, streak);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("Longest Sequence : " + longestConsecutive(nums)); 
    }
}