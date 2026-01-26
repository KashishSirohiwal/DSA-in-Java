package Arrays.LeetCode;

/*
 Problem: Remove Duplicates from Sorted Array

 Idea:
 - The array is already sorted.
 - We must keep only unique elements at the front.
 - The relative order of elements must be preserved.
 - The operation must be done in-place (no extra array).

 Technique Used:
 Same-direction Two Pointer Technique

 - One pointer (readIndex) scans the array.
 - One pointer (writeIndex) stores the position of the last unique element.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class RemoveDuplicateSortedArray {
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0; // Edge case: empty array

        // writeIndex points to the position of the last unique element
        int writeIndex = 0;

        // readIndex scans the array from the second element
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {

            // If current element is different from the last unique element
            if (nums[readIndex] != nums[writeIndex]) {
                writeIndex++;
                nums[writeIndex] = nums[readIndex]; // Store the new unique element
            }
        }
        
        return writeIndex + 1; // Number of unique elements
    }
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.print("Original Array : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        int k = removeDuplicates(nums);
        System.out.println("\n\nNumber of unique elements : " + k);

        System.out.print("Array after removing duplicates : ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
