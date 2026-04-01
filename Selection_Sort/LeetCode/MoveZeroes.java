package Selection_Sort.LeetCode;

/*
Problem: Move Zeroes

Idea:
 - Given an array, move all zeroes to the end while maintaining the relative order of non-zero elements.
 - The operation must be done in-place without making a copy of the array.

Technique Used:
 Selection Style (Compaction)

 - Use a pointer `pos` to track the position where the next non-zero should be placed.
 - Traverse the array:
     - If the current element is non-zero, place it at `nums[pos]` and increment `pos`.
 - After traversal, fill the remaining positions with zeroes.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int pos = 0; // pointer for non-zero placement

        // Compact non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        // Fill remaining positions with zeroes
        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 7};
        System.out.print("Original array : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        moveZeroes(nums);

        System.out.print("Array after moving zeroes : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}