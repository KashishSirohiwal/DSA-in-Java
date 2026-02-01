package Arrays.LeetCode;
import java.util.Scanner;

/*
 Problem: Sort Colors (LeetCode - Medium)

 Task:
 Given an array nums containing only 0s, 1s, and 2s,
 sort the array in-place so that:
     all 0s come first,
     then all 1s,
     then all 2s.

 Restrictions:
 - Do NOT use built-in sort functions.
 - Must be done in one pass.
 - Use constant extra space.

 Technique Used:
 Dutch National Flag Algorithm (Three Pointer Technique)

 Idea:
 - 0s should be placed at the beginning
 - 2s should be placed at the end
 - 1s stay in the middle

 Pointers:
 low  -> boundary for 0s
 mid  -> current element under inspection
 high -> boundary for 2s

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

public class SortColors {
    public void sortColors(int[] nums) {

        int low = 0; // Position for next 0
        int mid = 0; // Current element
        int high = nums.length - 1; // Position for next 2

        while (mid <= high) {

            // Case 1: Current element is 0
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                // Expand 0s region and move forward
                low++;
                mid++;
            }

            // Case 2: Current element is 1
            else if (nums[mid] == 1) {
                // 1 is already in correct position
                mid++;
            }

            // Case 3: Current element is 2
            else {
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                // Shrink 2s region
                high--;
                // Note: mid is NOT incremented here
                // because the swapped element is still unprocessed
            }
        }
    }

    public static void main(String[] args) {
        SortColors sorter = new SortColors();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements (0s, 1s, 2s):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Original Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sorter.sortColors(nums);

        System.out.print("\nSorted Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
